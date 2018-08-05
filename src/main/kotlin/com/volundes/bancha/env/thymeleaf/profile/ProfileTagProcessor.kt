package com.volundes.bancha.env.thymeleaf.profile

import org.thymeleaf.context.ITemplateContext
import org.thymeleaf.engine.AttributeName
import org.thymeleaf.model.IProcessableElementTag
import org.thymeleaf.standard.processor.AbstractStandardConditionalVisibilityTagProcessor
import org.thymeleaf.templatemode.TemplateMode

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

//    abstract fun isValidTag(attributeValue: String): Boolean

//    protected fun isValidTag(attributeValue: String): Boolean{
//        return false
//    }

}