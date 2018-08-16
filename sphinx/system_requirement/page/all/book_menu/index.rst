本メニュー
======================================

.. image:: img.png

.. uml::

  actor :非会員: as Non
  actor :会員: as General
  actor :管理者: as Admin
  
  (Bookを選択) as (Select Book)

  Non --> (Select Book)
  General --> (Select Book)
  Admin --> (Select Book)

