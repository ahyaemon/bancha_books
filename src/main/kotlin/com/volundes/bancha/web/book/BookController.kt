package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.BookService
import com.volundes.bancha.web.book.session.SubmitInfoList
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.time.LocalDateTime

@Controller
@RequestMapping("/book")
class BookController(
        private val helper: BookControllerHelper,
        private val service: BookService,
        private val submitInfoList: SubmitInfoList
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
        model.addAttribute("sentenceItem", helper.createSentenceItem(sentenceIdItem.sentenceId))
        model.addAttribute("commentForm", helper.createCommentForm(sentenceIdItem.bookId))
        return "book/comment :: comment"
    }

    @RequestMapping(value=["/createComment"], produces=["text/plain;charset=UTF-8"])
    fun createComment(
            @RequestBody @Validated commentForm: CommentForm,
            result: BindingResult,
            model: Model
    ): String{
        val submitDateTime = LocalDateTime.now()
        val bookId = commentForm.bookId
        val sentenceId = commentForm.sentenceId
        sentenceId  ?: return "book/index" // 本来nullで来ることはない

        // 連続投稿対策
        if(helper.hasSequentialSubmitError(submitDateTime, submitInfoList, bookId, sentenceId)){
            result.reject("commentForm.sequentialSubmit")
        }

        if(result.hasErrors()){
            model.addAttribute("sentenceItem", helper.createSentenceItem(sentenceId))
            return "book/comment :: comment"
        }

        service.createComment(sentenceId, commentForm.toComment())
        submitInfoList.addNewInfo(bookId, sentenceId, submitDateTime)
        model.addAttribute("sentenceItem", helper.createSentenceItem(sentenceId))
        model.addAttribute("commentForm", helper.createCommentForm(bookId))
        return "book/comment :: comment"
    }

}