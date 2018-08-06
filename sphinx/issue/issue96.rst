#78 subtitleを動的に変更するためのアノテーションが欲しい
===============================================================================

https://github.com/ahyaemon/bancha_books/issues/96

HandlerInterceptorを継承したDynamicSubtitleInterceptorにて、postHandle内でModelAndViewにsubtitleを追加する。

preHandleだとModelに詰めることができないので、postHandle。

@DynamicSubtitleが付与されたControllerにリクエストがある場合、Controler内のメソッド実行後に呼ばれる。

.. note::
  
  preHandleは、handlerMethod実行前にrequestをいじるために使う。

  postHandleは引数でModelAndViewを受け取れる。
