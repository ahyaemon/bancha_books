package com.volundes.bancha.env

import org.springframework.stereotype.Component

@Component
class StaticPathList{

    private val staticPathes = arrayOf(
            "/**/favicon.ico",
            "/images/**",
            "/css/**",
            "/javascript/**",
            "/lib/**",
            "/META-INF/**",
            "/resources/**"
    )

    fun get() = staticPathes

}