会員情報編集
======================================

.. uml::

  actor :会員: as General
  
  (名前の編集) as (Edit Name)
  (パスワードの編集) as (Edit Password)
  (メールアドレスの編集) as (Edit EmailAdress)
  (メモ欄の編集) as (Edit Memo)
  (公開情報の編集) as (Edit Opacity)

  General --> (Edit Name)
  General --> (Edit Password)
  General --> (Edit EmailAdress)
  General --> (Edit Memo)
  General --> (Edit Opacity)

