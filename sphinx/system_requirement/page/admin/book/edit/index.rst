本の編集
======================================

本を編集する。

文組の編集、コメントの編集は別ページに分けたほうがいいかもしれない。

.. uml::

  actor :管理者: as Admin

  (タイトルの編集) as (Edit Title)
  (著者の編集) as (Edit Author)
  (文組の編集) as (Edit Structure)
  (コメントの編集) as (Edit Comment)

  Admin --> (Edit Title)
  Admin --> (Edit Author)
  Admin --> (Edit Structure)
  Admin --> (Edit Comment)
  Admin --> (Edit Enabled)
