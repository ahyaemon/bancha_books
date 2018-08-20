編集する本の選択
======================================

DB内の本を一覧表示する。

公開可否・削除も当ページで行う。

.. uml::

  actor :管理者: as Admin
  
  (本の選択) as (Select Book)
  (公開可否の切り替え) as (Switch Enabled)
  (本の削除) as (Delete Book)

  Admin --> (Select Book)
  Admin --> (Swirch Enabled)
  Admin --> (Delete Book)

