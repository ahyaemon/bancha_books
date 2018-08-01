package com.volundes.bancha.web.menu

import com.volundes.bancha.domain.menu.MenuProvider
import com.volundes.bancha.domain.subtitle.SubtitleProvider
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class MenuController(
        private val subtitleProvider: SubtitleProvider,
        private val menuProvider: MenuProvider
) {

    @ModelAttribute("subtitle")
    fun subtitle(): String{
        return subtitleProvider.get("home")
    }

    @ModelAttribute("menuItems")
    fun menuItems(): List<MenuItem>{
        return menuProvider.get().map{ MenuItem(it) }
    }

    @RequestMapping("")
    fun index(): String{
        return "menu/index"
    }
}