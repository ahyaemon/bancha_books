#3 ルビの表示方法を検討する
======================================

https://github.com/ahyaemon/bancha_books/issues/3

sentenceテーブルに、ルビタグ付きの文章をそのまま突っ込む。

thymeleafのth:utextを使って、ルビタグを解釈させる。

::

  <p th:utext="${sentenceItem.sentence}" th:classappend="${sentenceItem.hasComment()} ? 'b'"></p>

こんな感じ。