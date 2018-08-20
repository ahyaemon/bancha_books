開発環境と本番環境の差
======================================

application.ymlでのprofilesの指定により、開発中はdev profile を使用する。

::

  spring:
    profiles:
      active: dev

本番環境では、環境変数にproductionを入れておくことで、devを上書く

::

  SPRING_PROFILES_ACTIVE=production

.. list-table:: Difference between dev and production

  * - 項目
    - dev
    - production
  * - データソース
    - ymlに直接書く。
    - 環境変数から取得する。
    
      なければymlに書いてある場所からとってくる。
  * - thymeleaf
    - th:profiles="dev"
    - th:profiles="production"
  * - scheduler
    - 動かない
    - 動く

