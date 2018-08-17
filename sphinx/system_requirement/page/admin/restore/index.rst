データ復元
======================================

flyway 初期投入データを除いたデータを、復元用ファイルとしてダウンロードする。

これにより、スキーマ変更などでDBを一度初期化しなければならない場合に対応する。

.. uml::

  actor :管理者: as Admin
  (DMLのダウンロード) as (Download DML)
  (CSVのダウンロード) as (Download CSV)

  Admin --> (Download DML)
  Admin --> (Download CSV)

