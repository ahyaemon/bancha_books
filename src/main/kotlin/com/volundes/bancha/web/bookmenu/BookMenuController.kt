package com.volundes.bancha.web.bookmenu

import com.volundes.bancha.domain.bookmenu.BookMenuService
import com.volundes.bancha.domain.paging.Page
import com.volundes.bancha.env.interceptor.subtitle.DynamicSubtitle
import org.seasar.doma.jdbc.SelectOptions
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
        val page = Page(2, 5)
        val bookMenus = service.getBookMenus(page)
        val bookMenuItems: List<BookMenuItem> = bookMenus.map{ BookMenuItem(it) }
        model.addAttribute("bookMenuItems", bookMenuItems)
        return "bookmenu/index"
    }

}