package com.volundes.bancha.web.admin.updatebook

import com.volundes.bancha.domain.admin.updatebook.UpdateBookService
import com.volundes.bancha.web.book.item.CommentCountedBookItem
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
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
        val updateBookMenus = service.getUpdateBookMenus()
        val updateBookMenuItems = updateBookMenus.map{ UpdateBookMenuItem(it) }
        model.addAttribute("updateBookMenuItems", updateBookMenuItems)

        return "admin/updatebook/index"
    }

    @RequestMapping("/{bookId}")
    fun edit(
        @PathVariable("bookId") bookId: String,
        model: Model
    ): String{
        val book = service.getCommentCountedBookByBookId(bookId.toLong())
        val bookItem = CommentCountedBookItem(book)
        model.addAttribute("bookItem", bookItem)

        return "admin/updatebook/edit"
    }

}
