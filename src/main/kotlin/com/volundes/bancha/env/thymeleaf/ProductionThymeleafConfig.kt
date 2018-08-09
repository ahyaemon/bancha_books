package com.volundes.bancha.env.thymeleaf

import com.volundes.bancha.env.thymeleaf.profile.ProductionProfileTagProcessor
import com.volundes.bancha.env.thymeleaf.profile.ProfileTagProcessor
import com.volundes.bancha.env.thymeleaf.profile.ProfileTagProcessorDialect
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver

@Configuration
@Profile("production")
class ProductionThymeleafConfig(
) {

    @Bean
    fun profileTagProcessor(): ProfileTagProcessor {
        return ProductionProfileTagProcessor()
    }

}