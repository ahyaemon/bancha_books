開発環境の作成
======================================

**1. python のインストール**

  sphinx は python 環境で動作するため、python をインストールする。

  公式サイトでお勧めされているのは 2.7 系。

**2. sphinx のインストール**

  ::

    pip install sphinx

**3. html レイアウトの設定**

  3.1. sphinx 用のテーマ rtd をインストール

    ::

      pip install sphinx_rtd_theme

  3.2. sphnx/conf.py のテーマ設定を変更

    ::

      html_theme = "sphinx_rtd_theme"

**4. plantuml のインストール**
  
  UML ダイアグラムを書くには、PlantUML が動作する環境を作る必要がある。

  TODO もっと詳しく書く
 
  4.1. jreのインストール

    kotlin で開発してるくらいだから普通はインストール済みのはず。
  
  4.2. PlantUML をダウンロード

    公式ページから jar ファイルをダウンロードしてくる。

  4.3. sphinx 用の PlantUML プラグインをインストール

    ::

      pip install sphinxcontrib.plantuml

  4.4. sphinx/conf.py に設定を追記

    ::
      
      extensions = [
        'sphinx.ext.autodoc',
        'sphinxcontrib.plantuml'
      ]

      plantuml = 'java -jar "C:\Program Files (x86)\PlantUML\plantuml.jar"'


