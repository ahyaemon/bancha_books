package com.volundes.bancha.web.about

import com.volundes.bancha.domain.subtitle.SubtitleProvider
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/about")
class AboutController(
        private val subtitleProvider: SubtitleProvider
) {

    @ModelAttribute("subtitle")
    fun subtitle(): String{
        return subtitleProvider.get("about")
    }

    @RequestMapping("/")
    fun index(model: Model): String{
        return "about/index"
    }

    @RequestMapping("/creator")
    fun us(): String {
        return "about/creator"
    }

}