package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.service.BookService
import com.volundes.bancha.web.book.form.CommentForm
import com.volundes.bancha.web.book.form.DeleteCommentForm
import com.volundes.bancha.web.book.item.SentenceItem
import com.volundes.bancha.web.book.session.SubmitInfoList
import com.volundes.bancha.web.book.session.SubmitSettings
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class BookControllerHelper(
        private val service: BookService,
        private val submitSettings: SubmitSettings
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

}