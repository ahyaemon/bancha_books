package com.volundes.bancha.env.interceptor.subtitle

import com.volundes.bancha.domain.subtitle.SubtitleProvider
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
@Aspect
class DynamicSubtitleInterceptor(
        private val subtitleProvider: SubtitleProvider
): HandlerInterceptor {
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, modelAndView: ModelAndView?) {
        if(modelAndView == null){
            return
        }

        val method = (handler as HandlerMethod).method
        val cls = method.declaringClass

        if(!cls.isAnnotationPresent(DynamicSubtitle::class.java)){
            return
        }

        val annotation = cls.getAnnotation(DynamicSubtitle::class.java)
        val titleCd = annotation.titleCd
        val subtitle = subtitleProvider.get(titleCd)
        modelAndView.addObject("subtitle", subtitle)
    }
}