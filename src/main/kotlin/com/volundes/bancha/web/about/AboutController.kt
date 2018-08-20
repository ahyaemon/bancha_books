package com.volundes.bancha.web.about

import com.volundes.bancha.env.interceptor.subtitle.DynamicSubtitle
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

/**
 * 「このページについて」画面を担うControllerです。
 */
@Controller
@RequestMapping("/about")
@DynamicSubtitle("about")
class AboutController(
) {

    /**
     * indexへのマッピングです。
     */
    @RequestMapping
    fun index(model: Model): String{
        return "about/index"
    }

    /**
     * 製作者情報ページへのマッピングです。
     */
    @RequestMapping("/creator")
    fun us(): String {
        return "about/creator"
    }

}