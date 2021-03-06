package com.volundes.bancha.web.book

import com.volundes.bancha.domain.obj.account.Account
import com.volundes.bancha.domain.service.book.BookService
import com.volundes.bancha.web.book.form.CommentForm
import com.volundes.bancha.web.book.form.CommentPagingForm
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
import javax.servlet.http.HttpSession

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
    @RequestMapping("/{id}")
    fun index(
            @PathVariable("id") bookId: String,
            @Nullable @RequestParam("page") pageNumber: Int?,
            model: Model
    ): String{
        val page = helper.createSentencePage(pageNumber, bookId.toLong())
        model.addAttribute("page", page)

        val bookItem = helper.createCommentCountedBookItem(bookId.toLong(), page)
        model.addAttribute("bookItem", bookItem)

        return "book/index"
    }

    /**
     * ajax。
     * コメントを表示します。
     */
    @RequestMapping(value = ["/getSentence"], produces=["text/plain;charset=UTF-8"])
    fun getSentence(
            @RequestBody sentenceIdItem: SentenceIdItem,
            model: Model,
            httpSession: HttpSession
    ): String {
        val page = helper.createCommentPage(1, sentenceIdItem.sentenceId)
        model.addAttribute("page", page)

        val account = httpSession.getAccount()
        val sentenceItem = if(account == null){
            // FIXME どのaccountIdとマッチしないものの判定だけど、-1ってどうなの
            helper.createSentenceItem(sentenceIdItem.sentenceId, -1, page)
        } else {
            helper.createSentenceItem(sentenceIdItem.sentenceId, account.id!!, page)
        }
        model.addAttribute("sentenceItem", sentenceItem)

        model.addAttribute(
                "commentForm",
                helper.createCommentForm(sentenceIdItem.bookId)
        )
        return "book/comment :: comment"
    }

    /**
     * コメントのページング処理を行います
     */
    @RequestMapping(value = ["/commentPaging"], produces=["text/plain;charset=UTF-8"])
    fun commentPaging(
            @RequestBody commentPagingForm: CommentPagingForm,
            model: Model,
            httpSession: HttpSession
    ): String {
        val page = helper.createCommentPage(commentPagingForm.pageNumber, commentPagingForm.sentenceId)
        model.addAttribute("page", page)

        val account = httpSession.getAccount()
        val sentenceItem = if(account == null){
            // FIXME どのaccountIdとマッチしないものの判定だけど、-1ってどうなの
            helper.createSentenceItem(commentPagingForm.sentenceId, -1, page)
        } else {
            helper.createSentenceItem(commentPagingForm.sentenceId, account.id!!, page)
        }
        model.addAttribute("sentenceItem", sentenceItem)

        return "book/comment_content :: comment_content"
    }

    /**
     * ajax。
     * コメントを新規登録します。
     * TODO 非会員のリクエスト改ざんでも登録できないようにする
     */
    @RequestMapping(value=["/createComment"], produces=["text/plain;charset=UTF-8"])
    fun createComment(
            @RequestBody @Validated commentForm: CommentForm,
            result: BindingResult,
            model: Model,
            httpSession: HttpSession
    ): String {
        val submitDateTime = LocalDateTime.now()
        val bookId = commentForm.bookId
        val sentenceId = commentForm.sentenceId
        sentenceId  ?: return "book/index" // 本来nullで来ることはない

        // 連続投稿対策
        if(helper.hasSequentialSubmitError(submitDateTime, submitInfoList, bookId, sentenceId)){
            result.reject("commentForm.sequentialSubmit")
        }

        val account = httpSession.getAccount()
        if(result.hasErrors()){
            // FIXME とりあえず最初のページに戻している
            val page = helper.createCommentPage(1, sentenceId)
            model.addAttribute("page", page)
            model.addAttribute(
                    "sentenceItem",
                    helper.createSentenceItem(sentenceId, account!!.id!!, page)
            )
            return "book/comment :: comment"
        }

        service.createComment(sentenceId, commentForm.toComment(account!!.id!!))
        submitInfoList.addNewInfo(bookId, sentenceId, submitDateTime)
        // FIXME とりあえず最初のページに戻している
        val page = helper.createCommentPage(1, sentenceId)
        model.addAttribute("page", page)
        model.addAttribute(
                "sentenceItem",
                helper.createSentenceItem(sentenceId, account.id!!, page)
        )
        model.addAttribute("commentForm", helper.createCommentForm(bookId))
        return "book/comment :: comment"
    }

    private fun HttpSession.getAccount(): Account? {
        val any = getAttribute("account")
        return  if(any == null) {
            null
        } else {
            any as Account
        }
    }

}