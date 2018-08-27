package com.volundes.bancha.env.security.config.web

import com.volundes.bancha.env.StaticPathList
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
@Order(2)
class GeneralSecurityConfig(
        private val staticPathList: StaticPathList
) : WebSecurityConfigurerAdapter(){

    /**
     * 静的コンテンツのアクセスはすべて許可
     */
    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(*staticPathList.get())
    }

    /**
     * 認証設定
     */
    override fun configure(http: HttpSecurity) {
        http.csrf().disable()

        http.antMatcher("/general/**")

        http.authorizeRequests()
                .antMatchers("/general/login").permitAll()
                .antMatchers("/general/**").authenticated()

        http.formLogin()
                .loginProcessingUrl("/general/auth")
                .loginPage("/general/login")
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .logoutUrl("/general/logout")
                .logoutSuccessUrl("/")
    }

}