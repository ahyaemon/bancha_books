package com.volundes.bancha.env.thymeleaf

import com.volundes.bancha.env.thymeleaf.profile.ProfileTagProcessor
import com.volundes.bancha.env.thymeleaf.profile.ProfileTagProcessorDialect
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.thymeleaf.spring5.SpringTemplateEngine
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver

@Configuration
class ThymeleafConfig(
        private val templateResolver: SpringResourceTemplateResolver,
        private val profileTagProcessor: ProfileTagProcessor
) {

    @Bean
    fun profileTagProcessorDialect(): ProfileTagProcessorDialect{
        return ProfileTagProcessorDialect(profileTagProcessor)
    }

    @Bean
    fun templateEngine(): SpringTemplateEngine{
        val templateEngine = SpringTemplateEngine()
        templateEngine.enableSpringELCompiler = true
        templateEngine.setTemplateResolver(templateResolver)
        templateEngine.addDialect(profileTagProcessorDialect())
        return templateEngine
    }

}