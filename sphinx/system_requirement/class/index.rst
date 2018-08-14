クラス図
======================================

メニュー: Menu
------------------------------

トップに表示するメニューを表す

.. uml::

  class Menu {
    id: Long
    title: String
    subtitle: String
    url: String
  }

サブタイトル: Subtitle
------------------------------

各画面にランダムで表示させる文を表す

.. uml::

  class Subtitle{
    id: Long
    title_cd: String
    value: String
  }

ブック: Book
------------------------------

一冊の本を表す

.. uml::

  class Book {
    Long: id
    title: String
    author: Author
    sentences: List<Sentence>
  }

  class Author {
    id: Long
    name: String
  }

  class Sentence {
    id: Long
    value: String
    comments: List<Comment>
  }

  class Comment {
    id: Long
    value: String
  }

  Book "1" *-- "0..n" Sentence
  Book "1" *-- "1..n" Author
  Sentence "1" *-- "0..n" Comment

アカウント: Account
------------------------------

サイトの登録者・管理人を表す

.. uml::

  class Account{
    id: Long
    name: String
    pass: String
    role: String
  }

寄付: Donation
------------------------------

寄付を表す

.. uml::

  class Donation{
    id: Long,
    name: String,
    comment: String,
    amount: Long
  }
