マイページ
======================================

.. uml::

  actor :会員: as General
  
  (お気に入りの本の確認) as (Show Favorite Books)
  (お気に入りの文の確認) as (Show Favorite Sentences)
  (お気に入りのコメントの確認) as (Show Favorite Comments)

  General --> (Show Favorite Books)
  General --> (Show Favorite Sentences)
  General --> (Show Favorite Comments)
