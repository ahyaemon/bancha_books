本
======================================

このサイトのメインコンテンツ。

**1. 画面**

**2. ユースケース図**

  .. uml::

    actor :非会員: as Non
    actor :会員: as General

    (文を読む) as (Read Sentence)  

    Non --> (Read Sentence)
    General --> (Read Sentence)

  .. uml::

    actor :非会員: as Non
    actor :会員: as General

    (コメントを読む) as (Read Comment)
    (コメント投稿) as (Submit Comment)
    (コメント削除) as (Delete Comment)

    Non --> (Read Comment)
    General --> (Read Comment)

    General --> (Submit Comment)

    General --> (Delete Comment)

**3. フォーム**

  3.1. コメント投稿

    .. list-table::

      * - 項目
        - type属性
        - 内容
        - 制約
        - 条件
      * - 名前
        - text
        - コメントする人の名前
        - 255文字以内
        - 
      * - コメント
        - textarea
        - コメント内容
        - 255文字以内
        - 
      * - 削除キーあり
        - checkbox
        - 削除キーを付与する場合はチェック
        -
        - 
      * - 削除キー
        - text
        - コメントを削除するための任意の文字列
        - 255文字以内
        - 表示: 「削除キーあり」にチェックがある場合

  3.2. コメント削除

    .. list-table::

      * - 項目
        - type属性
        - 内容
        - 制約
        - 条件
      * - 削除キー
        - text
        - コメントを削除するための任意の文字列
        - 255文字以内
        - 
