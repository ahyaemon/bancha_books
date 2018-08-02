#78 遅延初期化をうまいこと使う
======================================

https://github.com/ahyaemon/bancha_books/issues/78

subtitle, menuなどはテーブルの更新がないため、アプリケーション起動時に値を取得して保持しておく。

init文の中で初期化すると、DBアクセスがある場合はflywayMigrateが終わっていない可能性があるため動作が不定になる。

これを回避するため、lazyを使用して初回アクセス時に初期化する。

::

  private val subtitles  by lazy { mapper.toSubtitle( dao.select()) }

