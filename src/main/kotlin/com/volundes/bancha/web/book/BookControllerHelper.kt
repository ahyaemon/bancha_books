package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.BookService
import com.volundes.bancha.web.book.session.SubmitInfoList
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class BookControllerHelper(
        private val service: BookService
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
        // FIXME ここで5分決め打ちになっている
        val submitEnabledDateTime = prevDateTime.plusMinutes(5)
        return submitDateTime.isBefore(submitEnabledDateTime)
    }

    fun createSentenceItem(sentenceId: Long): SentenceItem {
        val sentence = service.getSentenceBySentenceId(sentenceId)
        return SentenceItem(sentence)
    }

    fun createCommentForm(bookId: Long): CommentForm {
        return CommentForm(bookId, null, "", "")
    }

}