ホームメニュー
======================================

.. image:: img.png

.. uml::

  actor :非会員: as Non
  actor :会員: as General
  actor :管理者: as Admin
  
  (Menuを選択) as (Select Menu)

  Non --> (Select Menu)
  General --> (Select Menu)
  Admin --> (Select Menu)

