package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.service.BookService
import com.volundes.bancha.domain.paging.Page
import com.volundes.bancha.env.setting.DisplayLimitSettings
import com.volundes.bancha.web.book.form.CommentForm
import com.volundes.bancha.web.book.form.DeleteCommentForm
import com.volundes.bancha.web.book.item.SentenceItem
import com.volundes.bancha.web.book.session.SubmitInfoList
import com.volundes.bancha.env.setting.SubmitSettings
import com.volundes.bancha.web.book.item.CommentCountedBookItem
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

    fun createSentenceItem(sentenceId: Long): SentenceItem {
        val sentence = service.getSentenceBySentenceId(sentenceId)
        return SentenceItem(sentence)
    }

    fun createCommentForm(bookId: Long): CommentForm {
        return CommentForm(bookId, null, "", "", false, "")
    }

    fun createDeleteCommentForm(): DeleteCommentForm {
        return DeleteCommentForm(0, 0, 0, "")
    }

    fun createCommentCountedBookItem(
            bookId: Long,
            page: Page
    ): CommentCountedBookItem{
        val book = service.getCommentCountedBookByBookId(bookId, page)
        return CommentCountedBookItem(book)
    }

    fun createPage(pageNumber: Int?, bookId: Long): Page {
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

}