package com.volundes.bancha.web.controller.about

import com.volundes.bancha.domain.provider.SubtitleProvider
import com.volundes.bancha.domain.service.BookMenuService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/about")
class AboutController(
        private val service: BookMenuService,
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

}