package com.volundes.bancha.web.admin.updatebook

import com.volundes.bancha.domain.admin.updatebook.UpdateBookService
import com.volundes.bancha.web.book.BookItem
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/updatebook")
class UpdateBookController(
        private val service: UpdateBookService
) {

    @RequestMapping("/")
    fun login(
            model: Model
    ): String{
        val updateBookItems = service.getBookInfos().map{ UpdateBookItem(it) }
        model.addAttribute("updateBookItems", updateBookItems)

        return "admin/updatebook/index"
    }

}