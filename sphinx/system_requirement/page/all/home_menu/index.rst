ホームメニュー
======================================

.. image:: img.png

.. uml::

  actor :非会員: as Non
  actor :会員: as General
  
  (Menuを選択) as (Select Menu)

  Non --> (Select Menu)
  General --> (Select Menu)
