本の追加
======================================

青空文庫からの本の追加を想定している。

.. uml::

  actor :管理者: as Admin
  
  (htmlファイルから追加) as (html)
  (txtファイルから追加) as (txt)
  (urlから追加) as (url)

  Admin --> (html)
  Admin --> (txt)
  Admin --> (url)
