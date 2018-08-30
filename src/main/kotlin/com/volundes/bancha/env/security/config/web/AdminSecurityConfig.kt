package com.volundes.bancha.env.security.config.web

import com.volundes.bancha.env.StaticPathList
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
@Order(1)
class AdminSecurityConfig(
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

        http.antMatcher("/admin/**")

        http.authorizeRequests()
                .antMatchers("/admin/login").permitAll()
                .antMatchers("/admin/**").authenticated()

        http.formLogin()
                .loginProcessingUrl("/admin/auth")
                .loginPage("/admin/login")
                .defaultSuccessUrl("/admin/menu")
                .and()
                .logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/")

    }

}