会員情報ページ
======================================

会員が公開している情報を見ることができる。

.. uml::

  actor :非会員: as Non
  actor :会員: as General

  (公開情報を見る) as (Read Info)  

  Non --> (Read Info)
  General --> (Read Info)
