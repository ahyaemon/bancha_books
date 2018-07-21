package com.volundes.bancha.config

import org.apache.catalina.core.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder

@EnableWebSecurity
class WebSecurityConfig(
        private val userDetailsService: UserDetailsService
) : WebSecurityConfigurerAdapter(){

    @SuppressWarnings("deprecation")
    @Bean
    fun passwordEncoder2(): NoOpPasswordEncoder{
        return NoOpPasswordEncoder.getInstance() as NoOpPasswordEncoder
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder{
        return BCryptPasswordEncoder()
    }

    override fun configure(auth: AuthenticationManagerBuilder){
        val passwordEncoder = passwordEncoder()
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
    }

    /**
     * 静的コンテンツのアクセスはすべて許可
     */
    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(
                "/**/favicon.ico",
                "/images/**",
                "/css/**",
                "/javascript/**",
                "/lib/**"
        )
    }

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()

        http.authorizeRequests()
                .antMatchers("/admin/login").permitAll()
                .antMatchers("/admin/**").authenticated()

        http.formLogin()
                .loginProcessingUrl("/admin/auth")
                .loginPage("/admin/login")
                .defaultSuccessUrl("/admin/menu")
                .and().logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/")

    }

}