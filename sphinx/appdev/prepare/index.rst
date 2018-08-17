開発環境の作成
======================================

**1. IntelliJのインストール**

  できればultimate版のほうがいい。
  
  js, ts, thymeleafなどがサポートされるらしい。

  あとFileWatchersとかもultimate

**2. プロジェクトのクローン**

    ::

      git clone <URL>

**3. プロジェクトをIntelliJにインポート**

  やり方はふた通り？

  1. IntelliJ用のプロジェクトを作成してインポート

    ::

      gradlew idea

    でプロジェクトファイルができるから、それをIntelliJでインポート。

    でもこれをやると、IntelliJからのアプリ起動がうまくいかない？？

    つまりデバッグができない。

  2. build.gradle をインポート

    インポート後、File -> Project Structure -> Project Settings -> Modules -> Pathsタブ から、
    Compiler output に Inherit project compile output path を選択する。

    基本的にはこれでうまくいく。

    でも、gradleコマンドを実行するたびに Inherit project compile output pathの設定が初期化される？

**4. IntelliJのアノテーションプロセッシングの設定**

  インポートが完了したら、Doma用にAnnotation解釈の設定をする。