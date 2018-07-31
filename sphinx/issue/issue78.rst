.. sphinxtest documentation master file, created by
   sphinx-quickstart on Thu Jul 19 08:36:27 2018.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

#78 遅延初期化をうまいこと使う
======================================

https://github.com/ahyaemon/bancha_books/issues/78

subtitle, menuなどはテーブルの更新がないため、アプリケーション起動時に値を取得して保持しておく。

init文の中で初期化すると、DBアクセスがある場合はflywayMigrateが終わっていない可能性があるため動作が不定になる。

これを回避するため、lazyを使用して初回アクセス時に初期化する。

::

  private val subtitles  by lazy { mapper.toSubtitle( dao.select()) }

