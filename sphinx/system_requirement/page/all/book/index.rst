本
======================================

.. uml::

  actor :非会員: as Non
  actor :会員: as General
  actor :管理者: as Admin

  (文を読む) as (Read Sentence)  

  Non --> (Read Sentence)
  General --> (Read Sentence)
  Admin --> (Read Sentence)

.. uml::

  actor :非会員: as Non
  actor :会員: as General
  actor :管理者: as Admin

  (コメントを読む) as (Read Comment)
  (コメント投稿) as (Submit Comment)
  (コメント削除) as (Delete Comment)

  Non --> (Read Comment)
  General --> (Read Comment)
  Admin --> (Read Comment)

  General --> (Submit Comment)
  Admin --> (Submit Comment)

  Admin --> (Delete Comment)

