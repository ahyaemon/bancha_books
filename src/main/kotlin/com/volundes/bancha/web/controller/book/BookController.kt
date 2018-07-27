package com.volundes.bancha.web.controller.book

import com.volundes.bancha.domain.service.BookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/book")
class BookController(
        private val service: BookService
) {

    @RequestMapping("/{bookId}")
    fun index(
            @PathVariable("bookId") bookId: String,
            model: Model
    ): String{
        val bookItem = BookItem(service.getBookByBookId(bookId))
        model.addAttribute("bookItem", bookItem)

        val sentenceForms = service.getSentences(bookId).map{ SentenceForm(it) }
        model.addAttribute("sentenceForms", sentenceForms)

        val commentForm = CommentForm()
        model.addAttribute("commentForm", commentForm)

        return "book/index"
    }

    @RequestMapping(value=["/createComment"], produces=["text/plain;charset=UTF-8"])
    fun createComment(
            @RequestBody @Validated commentForm: CommentForm,
            result: BindingResult,
            model: Model
    ): String{
        val sentenceId = commentForm.sentenceId
        sentenceId  ?: return "" // TODO nullだったらどうする
        model.addAttribute("sid", sentenceId)

        if(result.hasErrors()){
            val commentItems= service.getComments(sentenceId).map{ CommentItem(it) }
            model.addAttribute("commentItems", commentItems)
            return "book/comment :: comment"
        }

        service.createComment(sentenceId, commentForm.toComment())
        val commentItems= service.getComments(sentenceId).map{ CommentItem(it) }
        model.addAttribute("commentItems", commentItems)

        val newCommentForm = CommentForm(sentenceId = sentenceId)
        model.addAttribute("commentForm", newCommentForm)

        return "book/comment :: comment"
    }

}