package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.BookService
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
        val book = service.getCommentCountedBookByBookId(bookId.toLong())
        val bookItem = CommentCountedBookItem(book)
        model.addAttribute("bookItem", bookItem)

        return "book/index"
    }

    @RequestMapping(value = ["/getSentence"], produces=["text/plain;charset=UTF-8"])
    fun getSentence(
            @RequestBody sentenceIdItem: SentenceIdItem,
            model: Model
    ): String{
        val sentence = service.getSentenceBySentenceId(sentenceIdItem.sentenceId)
        val sentenceItem = SentenceItem(sentence)
        model.addAttribute("sentenceItem", sentenceItem)

        val commentForm = CommentForm(null, "", "")
        model.addAttribute("commentForm", commentForm)
        return "book/comment :: comment"
    }

    @RequestMapping(value=["/createComment"], produces=["text/plain;charset=UTF-8"])
    fun createComment(
            @RequestBody @Validated commentForm: CommentForm,
            result: BindingResult,
            model: Model
    ): String{
        val sentenceId = commentForm.sentenceId
        sentenceId  ?: return "book/index" // 本来nullで来ることはない

        if(result.hasErrors()){
            val sentence = service.getSentenceBySentenceId(sentenceId)
            val sentenceItem = SentenceItem(sentence)
            model.addAttribute("sentenceItem", sentenceItem)
            return "book/comment :: comment"
        }

        service.createComment(sentenceId, commentForm.toComment())

        val sentence = service.getSentenceBySentenceId(sentenceId)
        val sentenceItem = SentenceItem(sentence)
        model.addAttribute("sentenceItem", sentenceItem)

        val commentForm = CommentForm(null, "", "")
        model.addAttribute("commentForm", commentForm)
        return "book/comment :: comment"
    }

}