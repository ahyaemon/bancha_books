package com.volundes.bancha.config.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.crypto.password.NoOpPasswordEncoder

@Configuration
@Profile("dev")
class DevSecurityConfig{

    @Autowired
    fun configure(auth: AuthenticationManagerBuilder){
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("admin").password("password").roles("ADMIN")
    }

}