package com.volundes.bancha.web.controller.book

import com.volundes.bancha.domain.dto.Comment
import com.volundes.bancha.domain.service.BookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/book")
class BookController(
        private val service: BookService
) {
    @RequestMapping("/")
    fun noisbn(): String{
        return "redirect:/bookmenu/"
    }

    @RequestMapping("/{bookId}")
    fun index(
            @PathVariable("bookId") bookId: String,
            model: Model
    ): String{
        val bookItem = BookItem(service.getBookInfo(bookId))
        model.addAttribute("bookItem", bookItem)

        val sentenceItems = service.getSentences(bookId).map{ SentenceItem(it) }
        model.addAttribute("sentenceItems", sentenceItems)

        return "book/index"
    }

    @RequestMapping(value="/createComment", produces=["text/plain;charset=UTF-8"])
    fun createComment(
            @RequestBody commentForm: CommentForm,
            model: Model
    ): String{
        val sentenceId = commentForm.sentenceId
        val comment= commentForm.toComment()
        service.createComment(sentenceId, comment)

        val commentItems= service.getComments(sentenceId).map{ CommentItem(it) }
        model.addAttribute("commentItems", commentItems)
        return "book/comment :: comment"
    }

}