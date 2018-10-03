package com.volundes.bancha.web.admin.updatebook

import com.volundes.bancha.domain.service.admin.updatebook.UpdateBookService
import com.volundes.bancha.web.book.item.CommentCountedBookItem
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

/**
 * 「本の編集」画面を担うControllerです。
 */
@Controller
@RequestMapping("/admin/updatebook")
class UpdateBookController(
        private val service: UpdateBookService
) {

    /**
     * indexへのマッピングです。
     */
    @RequestMapping("/")
    fun index(
            model: Model
    ): String{
        val updateBookInfos = service.getUpdateBookInfos()
        val updateBookMenuItems = updateBookInfos.map{ UpdateBookMenuItem(it) }
        model.addAttribute("updateBookMenuItems", updateBookMenuItems)

        return "admin/updatebook/index"
    }

    /**
     * ajax。
     * 本を更新します。
     */
    @RequestMapping("/{id}")
    fun edit(
        @PathVariable("id") bookId: String,
        model: Model
    ): String{
        val book = service.getCommentCountedBookByBookId(bookId.toLong())
        val bookItem = CommentCountedBookItem(book)
        model.addAttribute("bookItem", bookItem)

        return "admin/updatebook/edit"
    }

}
