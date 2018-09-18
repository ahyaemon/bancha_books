package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.service.BookService
import com.volundes.bancha.domain.paging.Page
import com.volundes.bancha.env.setting.DisplayLimitSettings
import com.volundes.bancha.env.setting.SubmitSettings
import com.volundes.bancha.web.book.form.CommentForm
import com.volundes.bancha.web.book.item.CommentCountedBookItem
import com.volundes.bancha.web.book.item.SentenceItem
import com.volundes.bancha.web.book.session.SubmitInfoList
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class BookControllerHelper(
        private val service: BookService,
        private val submitSettings: SubmitSettings,
        private val displayLimitSettings: DisplayLimitSettings
) {

    fun hasSequentialSubmitError(
            submitDateTime: LocalDateTime,
            submitInfoList: SubmitInfoList,
            bookId: Long,
            sentenceId: Long
    ): Boolean {
        if(!submitInfoList.contains(bookId, sentenceId)) {
            return false
        }

        val prevSubmitInfo = submitInfoList.get(bookId, sentenceId)
        val prevDateTime = prevSubmitInfo.submitDateTime
        val submitEnabledDateTime = prevDateTime.plusSeconds(submitSettings.duration)
        return submitDateTime.isBefore(submitEnabledDateTime)
    }

    fun createSentenceItem(
            sentenceId: Long,
            accountId: Long,
            page: Page
    ): SentenceItem {
        val sentence = service.getSentenceBySentenceId(sentenceId, page)
        return SentenceItem(sentence, accountId)
    }

    fun createCommentForm(bookId: Long): CommentForm {
        return CommentForm(bookId, null, "")
    }

    fun createCommentCountedBookItem(
            bookId: Long,
            page: Page
    ): CommentCountedBookItem{
        val book = service.getCommentCountedBookByBookId(bookId, page)
        return CommentCountedBookItem(book)
    }

    fun createSentencePage(pageNumber: Int?, bookId: Long): Page {
        val totalSentenceAmount = service.getTotalSentenceAmount(bookId)
        val currentPage =
                if(pageNumber == null) 1
                else pageNumber
        return Page(
                currentPage,
                displayLimitSettings.sentence,
                totalSentenceAmount,
                "/book/$bookId"
        )
    }

    fun createCommentPage(pageNumber: Int, sentenceId: Long): Page{
        val totalCommentAmount = service.getTotalCommentAmount(sentenceId)
        return Page(
                pageNumber,
                displayLimitSettings.comment,
                totalCommentAmount,
                "/book/commentPaging"
        )
    }

}