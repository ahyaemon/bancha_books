#77 lessの導入
======================================

https://github.com/ahyaemon/bancha_books/issues/77

cssはlessを使って作成する。

開発環境はless.jsを使用してlessファイルのまま使用し、本番環境ではcssにコンパイルしたものを使用する。

### 環境切り替え方法

AbstractStandardConditionalVisibilityTagProcessorを継承したProfileTagProcessorを作成し、
th:profileに対するDialectを定義する。

::

  abstract class ProfileTagProcessor(
        private val isValidTag: (String) -> Boolean
  ): AbstractStandardConditionalVisibilityTagProcessor(
          TemplateMode.HTML,
          "th",
          "profile",
          300
  ) {

    override fun isVisible(
            context: ITemplateContext?,
            tag: IProcessableElementTag?,
            attributeName: AttributeName?,
            attributeValue: String?
    ): Boolean {
        if(attributeValue == null){
            return false
        }
        return isValidTag(attributeValue)
    }
  }

開発環境・本番環境のそれぞれについてProfileTagProcessorを継承したクラスを作成し、profileによって切り替えるようにconfigurationで設定する。

::

  class DevProfileTagProcessor: ProfileTagProcessor({ it == "dev" })

::
 
  class ProductionProfileTagProcessor: ProfileTagProcessor({ it == "production" })

  