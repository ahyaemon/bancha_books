package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.service.BookService
import com.volundes.bancha.web.book.form.CommentForm
import com.volundes.bancha.web.book.form.DeleteCommentForm
import com.volundes.bancha.web.book.item.CommentCountedBookItem
import com.volundes.bancha.web.book.item.SentenceIdItem
import com.volundes.bancha.web.book.session.SubmitInfoList
import org.springframework.lang.Nullable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDateTime

/**
 * 「本」画面を担うControllerです。
 */
@Controller
@RequestMapping("/book")
class BookController(
        private val helper: BookControllerHelper,
        private val service: BookService,
        private val submitInfoList: SubmitInfoList
) {

    /**
     * indexへのマッピングです。
     */
    @RequestMapping("/{bookId}")
    fun index(
            @PathVariable("bookId") bookId: String,
            @Nullable @RequestParam("page") pageNumber: Int?,
            model: Model
    ): String{
        val page = helper.createPage(pageNumber, bookId.toLong())
        model.addAttribute("page", page)

        model.addAttribute("bookItem",
                helper.createCommentCountedBookItem(bookId.toLong(), page))
        model.addAttribute("deleteCommentForm", helper.createDeleteCommentForm())
        return "book/index"
    }

    /**
     * ajax。
     * sentenceを book/comment にマッピングします。
     */
    @RequestMapping(value = ["/getSentence"], produces=["text/plain;charset=UTF-8"])
    fun getSentence(
            @RequestBody sentenceIdItem: SentenceIdItem,
            model: Model
    ): String{
        model.addAttribute("sentenceItem", helper.createSentenceItem(sentenceIdItem.sentenceId))
        model.addAttribute("commentForm", helper.createCommentForm(sentenceIdItem.bookId))
        return "book/comment :: comment"
    }

    /**
     * ajax。
     * コメントを新規登録します。
     */
    @RequestMapping(value=["/createComment"], produces=["text/plain;charset=UTF-8"])
    fun createComment(
            @RequestBody @Validated commentForm: CommentForm,
            result: BindingResult,
            model: Model
    ): String {
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

    /**
     * ajax。
     * コメントを削除します。
     */
    @RequestMapping(value=["/deleteComment"], produces=["text/plain;charset=UTF-8"])
    fun deleteComment(
            @RequestBody @Validated deleteCommentForm: DeleteCommentForm,
            result: BindingResult,
            model: Model
    ): String {
        val canDelete = service.canDeleteComment(deleteCommentForm.commentId, deleteCommentForm.deleteKey)

        if(!canDelete){
            result.reject("deleteCommentForm.invalidDeleteKey")
            return "book/delete :: delete"
        }

        service.deleteComment(deleteCommentForm.commentId)
        model.addAttribute("sentenceItem", helper.createSentenceItem(deleteCommentForm.sentenceId))
        model.addAttribute("commentForm", helper.createCommentForm(deleteCommentForm.bookId))
        model.addAttribute("deleteCommentForm", helper.createDeleteCommentForm())
        return "book/comment :: comment"
    }

}