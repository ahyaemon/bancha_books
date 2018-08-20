githubとの連携
===================

1. github pages

  githubリポジトリ直下にdocsディレクトリを作成し、そこにhtmlファイルを置くことで、webサイトとして公開することができる。

  当サイトはその機能を使用している。

2. copydocs

  makeで出来上がった成果物はsphinx/_buildディレクトリ以下に配置されるため、docsディレクトリまでコピーする必要がある。

  copydocs.batを実行すればこれが完了する。

  ::

    @echo off

    set DOCDIR=..\docs
    set HTMLDIR=_build\html

    rem delete doc directory
    rem /s: recurfsive
    rem /q: no confirmation
    rmdir /s/q  %DOCDIR%

    rem copy html to doc directory without unnesessary files
    rem /e: recursive
    rem /y: no confirmation
    xcopy /e/y/exclude:exclude.list %HTMLDIR%\* %DOCDIR%\

    rem create .nojekyll to ignore github jekyll encoding
    type nul > %DOCDIR%\.nojekyll

  .. note::

    ここでnojekyllを作成しているのは、github側で勝手に走るjekyllを抑制するためである。

    （docsディレクトリに置いたhtmlは、jekyllによる解析後にサーバーにアップされるみたい）
