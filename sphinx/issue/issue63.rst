.. sphinxtest documentation master file, created by
   sphinx-quickstart on Thu Jul 19 08:36:27 2018.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

#63 デプロイ時のDB初期化対策を考える
======================================

https://github.com/ahyaemon/bancha_books/issues/63

問題
----

スキーマの変更や初期データの変更がある場合、herokuにそのままデプロイするとflywayMigrateで失敗する。

⇒ migrateの前にcleanすればいいのでは？

⇒ そうすると、commentやdonationなどのデータが消えてしまう。

対応
----

以下の2点の実装。

#. 復元用データのエクスポート機能
#. 復元用スクリプト（restore.script）を META-INF/ ~ /RestoreDao/restore.stript に置くことで、復元を実行する

アプリケーション起動時の流れは以下。

+ 更新がない場合：なにもしない
+ 更新がある場合：

  #. clean
  #. migrate
  #. 初期投入データテーブルへのデータインサート
  #. restore.scriptからデータの復元

.. note::
  flywayにて投入する初期データは、復元用データに含めない。
  （含めると二重でインサートになってしまう。）
  そのため、DBに初期データ判断用の専用のテーブルを作成し、復元用データエクスポート時に初期データは除外する。

.. code-block:: kotlin
  :caption: FlywayCleanConfig.kt

  fun initDB(){
      val flyway = Flyway()
      flyway.dataSource = dataSource

      if(flyway.notUpdated()){
          logger.info("Skipping flyway clean and migration.")
          return
      }

      flyway.clean()
      flyway.migrate()

      try{
          unrestoreRepository.init()
          logger.info("Creating unrestore data success.")
      }
      catch(e: Exception){
          logger.warn("Failed to create unrestore data.", e)
      }

      try{
          restoreRepository.restore()
          logger.info("Restore data success.")
      }
      catch(e: Exception){
          logger.warn("Failed to restore data.", e)
      }
  }

