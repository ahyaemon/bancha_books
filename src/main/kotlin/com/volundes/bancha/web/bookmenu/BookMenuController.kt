package com.volundes.bancha.web.bookmenu

import com.volundes.bancha.domain.service.bookmenu.BookMenuService
import com.volundes.bancha.domain.page.Page
import com.volundes.bancha.env.interceptor.subtitle.DynamicSubtitle
import com.volundes.bancha.env.setting.DisplayLimitSettings
import org.springframework.lang.Nullable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/bookmenu")
@DynamicSubtitle("bookmenu")
class BookMenuController(
        private val service: BookMenuService,
        private val displayLimitSettings: DisplayLimitSettings
) {

    @RequestMapping
    fun index(
            @Nullable @RequestParam("page") pageNumber: Int?,
            model: Model
    ): String{
        val page = pageNumber.createPage()
        model.addAttribute("page", page)

        val bookInfoItems = service.getBookInfos(page).map{ BookInfoItem(it) }
        model.addAttribute("bookInfoItems", bookInfoItems)

        return "bookmenu/index"
    }

    private fun Int?.createPage(): Page {
        val totalBookAmount = service.getTotalBookAmount()
        val currentPage =
                if(this == null) 1
                else this
        return Page(
                currentPage,
                displayLimitSettings.book,
                totalBookAmount,
                "/bookmenu"
        )
    }

}