package com.volundes.bancha.config.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder

@Configuration
@Profile("dev")
class DevSecurityConfig{

    @Autowired
    fun configure(auth: AuthenticationManagerBuilder){
        @Suppress("DEPRECATION")
        auth.inMemoryAuthentication().passwordEncoder(
                org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
                .withUser("admin")
                .password("password")
                .roles("ADMIN")
    }

}