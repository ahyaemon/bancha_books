package com.volundes.bancha.env.thymeleaf

import com.volundes.bancha.env.thymeleaf.profile.DevProfileTagProcessor
import com.volundes.bancha.env.thymeleaf.profile.ProfileTagProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("dev")
class DevThymeleafConfig(
) {

    @Bean
    fun profileTagProcessor(): ProfileTagProcessor {
        return DevProfileTagProcessor()
    }

}