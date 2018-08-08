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
        // TODO BookItemでは、SentenceItemに紐づくのはcommentの数
        // TODO 画面に表示しないのに、全コメントをselectしてしまっている
        val book = service.getBookByBookId(bookId.toLong())
        val bookItem = BookItem(book)
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
        sentenceId  ?: return "" // TODO nullだったらどうする

        if(result.hasErrors()){
            val sentence = service.getSentenceBySentenceId(commentForm.sentenceId)
            val sentenceItem = SentenceItem(sentence)
            model.addAttribute("sentenceItem", sentenceItem)
            return "book/comment :: comment"
        }

        service.createComment(sentenceId, commentForm.toComment())

        val sentence = service.getSentenceBySentenceId(commentForm.sentenceId)
        val sentenceItem = SentenceItem(sentence)
        model.addAttribute("sentenceItem", sentenceItem)

        val commentForm = CommentForm(null, "", "")
        model.addAttribute("commentForm", commentForm)
        return "book/comment :: comment"
    }

}