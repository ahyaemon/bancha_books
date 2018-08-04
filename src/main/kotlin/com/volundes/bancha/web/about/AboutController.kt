package com.volundes.bancha.web.about

import com.volundes.bancha.env.interceptor.subtitle.DynamicSubtitle
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/about")
@DynamicSubtitle("about")
class AboutController(
) {

    @RequestMapping("/")
    fun index(model: Model): String{
        return "about/index"
    }

    @RequestMapping("/creator")
    fun us(): String {
        return "about/creator"
    }

}