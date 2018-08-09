package com.volundes.bancha.web.bookmenu

import com.volundes.bancha.domain.bookmenu.BookMenuService
import com.volundes.bancha.env.interceptor.subtitle.DynamicSubtitle
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/bookmenu")
@DynamicSubtitle("bookmenu")
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