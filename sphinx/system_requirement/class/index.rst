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
    id: Long
    book_info: BookInfo
    sentences: List<Sentence>
  }

  class BookInfo {
    id: Long
    title: String
    author: Author
    license: License
  }

  class License {
    id: Long
    notice: String
    license_type: String
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

  Book "1" *-- "1" BookInfo
  Book "1" *-- "1..n" Sentence
  BookInfo "1" *-- "1" Author
  BookInfo "1" *-- "0..1" License
  Sentence "1" *-- "0..n" Comment

アカウント: Account
------------------------------

サイトの登録者・管理人を表す

.. uml::

  class Account{
    id: Long,
    name: Stirng
    authInfo: AuthInfo
    hitokoto: Hitokoto
  }

  class AuthInfo{
    id: Long
    email: String
    pass: String
    role: String
  }

  class Hitokoto{
    id: Long
    value: String
  }

  Account "1" *-- "1" AuthInfo
  Account "1" *-- "0..1" Hitokoto

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
