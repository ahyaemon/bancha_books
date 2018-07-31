# bancha_books
herokuブランチの更新で、herokuに自動デプロイされる  
https://banchabooks.herokuapp.com/

## 1. 概要
文章に対してコメントができるサービス

ドキュメント兼仕様書（未完成）
https://ahyaemon.github.io/bancha_books/

## 2. 開発環境
### 2.1. 使用言語・ツール
- kotlin 1.2.41
- Java 8
- intellij

※ java10 でやったら動かなかった

### 2.2 使用ライブラリ
#### バック側
- springboot 2.0.3
- spring security
- quartz scheduler
- Doma2 2.19.2
- postgresql 9.6.2
- flyway 5.1.4

#### フロント側
- siimple.css 3.1.0
- anime.js 2.2.0

#### ドキュメント
- sphinx

### 2.3 Doma2 + intellij の開発について
アノテーション解釈のため、プロジェクトインポート後にintellij側でいくつか設定が必要。  
https://doma.readthedocs.io/ja/latest/getting-started-idea/
