package com.volundes.bancha.web.controller.admin.updatebook

import com.volundes.bancha.domain.service.UpdateBookService
import com.volundes.bancha.web.controller.book.BookItem
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
        val bookItems = service.getBooks().map{ BookItem(it) }
        model.addAttribute("bookItems", bookItems)

        return "admin/updatebook/index"
    }

}