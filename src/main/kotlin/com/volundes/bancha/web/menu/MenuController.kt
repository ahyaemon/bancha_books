package com.volundes.bancha.web.menu

import com.volundes.bancha.domain.menu.MenuProvider
import com.volundes.bancha.env.interceptor.subtitle.DynamicSubtitle
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
@DynamicSubtitle("home")
class MenuController(
        private val menuProvider: MenuProvider
) {

    @ModelAttribute("menuItems")
    fun menuItems(): List<MenuItem>{
        return menuProvider.get().map{ MenuItem(it) }
    }

    @RequestMapping("")
    fun index(): String{
        return "menu/index"
    }
}