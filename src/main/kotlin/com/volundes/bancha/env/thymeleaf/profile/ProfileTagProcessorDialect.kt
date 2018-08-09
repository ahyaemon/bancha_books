package com.volundes.bancha.env.thymeleaf.profile

import org.thymeleaf.dialect.AbstractProcessorDialect
import org.thymeleaf.processor.IProcessor
import org.thymeleaf.standard.StandardDialect

class ProfileTagProcessorDialect(
        private val profileTagProcessor: ProfileTagProcessor
)
    : AbstractProcessorDialect(
        "ProfileTagProcessorDialect",
        "th",
        StandardDialect.PROCESSOR_PRECEDENCE
) {
    override fun getProcessors(dialectPrefix: String?): MutableSet<IProcessor> {
        return mutableSetOf(profileTagProcessor)
    }
}