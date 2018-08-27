package com.volundes.bancha.env.security.config.authentication

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@Profile("dev")
class DevSecurityConfig{

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        @Suppress("DEPRECATION")
        return org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance()
    }


    @Autowired
    fun configure(auth: AuthenticationManagerBuilder){
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("admin")
                .password("password")
                .roles("ADMIN")
                .and()
                .withUser("anji")
                .password("pass")
                .roles("GENERAL")
                .and()
                .withUser("baiken")
                .password("pass")
                .roles("GENERAL")
                .and()
                .withUser("may")
                .password("pass")
                .roles("GENERAL")
    }

}