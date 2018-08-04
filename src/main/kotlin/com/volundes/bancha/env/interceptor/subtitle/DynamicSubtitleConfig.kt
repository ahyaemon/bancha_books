package com.volundes.bancha.env.interceptor.subtitle

import com.volundes.bancha.env.StaticPathList
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
class DynamicSubtitleConfig(
        private val dynamicSubtitleInterceptor: DynamicSubtitleInterceptor,
        private val staticPathList: StaticPathList
) : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(dynamicSubtitleInterceptor)
                .excludePathPatterns(*staticPathList.get())
    }
}