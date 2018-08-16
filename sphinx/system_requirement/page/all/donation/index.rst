寄付
======================================

.. image:: img.png

.. uml::

  actor :非会員: as Non
  actor :会員: as General
  actor :管理者: as Admin
  
  (Line Payで寄付する) as (Donate as Line Pay)
  (Test Payで寄付する) as (Donate as Test Pay)
  (寄付詳細を表示する) as (Show Donation Details)

  Non --> (Donate as Line Pay)
  General --> (Donate as Line Pay)
  Admin --> (Donate as Line Pay)

  Non --> (Donate as Test Pay)
  General --> (Donate as Test Pay)
  Admin --> (Donate as Test Pay)

  Non --> (Show Donation Details)
  General --> (Show Donation Details)
  Admin --> (Show Donation Details)
