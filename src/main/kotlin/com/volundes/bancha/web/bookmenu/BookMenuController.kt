package com.volundes.bancha.web.bookmenu

import com.volundes.bancha.domain.bookmenu.BookMenuService
import com.volundes.bancha.domain.paging.Page
import com.volundes.bancha.env.interceptor.subtitle.DynamicSubtitle
import org.springframework.lang.Nullable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/bookmenu")
@DynamicSubtitle("bookmenu")
class BookMenuController(
        private val service: BookMenuService
) {

    @RequestMapping
    fun index(
            @Nullable @RequestParam("page") pageNumber: Int?,
            model: Model
    ): String{
        val page = pageNumber.createPage()
        model.addAttribute("page", page)

        val bookMenus = service.getBookMenus(page)
        val bookMenuItems: List<BookMenuItem> = bookMenus.map{ BookMenuItem(it) }
        model.addAttribute("bookMenuItems", bookMenuItems)

        return "bookmenu/index"
    }

    private fun Int?.createPage(): Page {
        val totalBookAmount = service.getTotalBookAmount()
        val currentPage =
                if(this == null) 1
                else this
        return Page(currentPage, 5, totalBookAmount, "/bookmenu")
    }

}