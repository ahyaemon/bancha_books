package com.volundes.bancha.web.controller.bookmenu

import com.volundes.bancha.domain.service.BookMenuService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/bookmenu")
class BookMenuController(
        private val service: BookMenuService
) {

    @RequestMapping("/")
    fun index(model: Model): String{
        val bookMenuItems: List<BookMenuItem> = service.getBookMenus().map{ BookMenuItem(it) }
        model.addAttribute("bookMenuItems", bookMenuItems)
        return "bookmenu/index"
    }

}