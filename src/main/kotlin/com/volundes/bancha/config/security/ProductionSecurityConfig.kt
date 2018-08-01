package com.volundes.bancha.config.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

//@EnableWebSecurity
@Configuration
@Profile("production")
class ProductionSecurityConfig(
        private val userDetailsService: UserDetailsService
){

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder{
        return BCryptPasswordEncoder()
    }

    @Autowired
    fun configure(auth: AuthenticationManagerBuilder){
        val passwordEncoder = passwordEncoder()
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
    }

}