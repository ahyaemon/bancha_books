package com.volundes.bancha.domain.service.book

import com.volundes.bancha.domain.obj.book.Book
import com.volundes.bancha.domain.obj.book.Comment
import com.volundes.bancha.domain.obj.book.Sentence
import com.volundes.bancha.domain.page.Page
import com.volundes.bancha.infra.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * 本の管理を担うサービスです。
 */
@Service
@Transactional
class BookService(
        private val repository: BookRepository
) {

    fun getWithCommentCountMap(
            bookId: Long,
            page: Page
    ): Pair<Book, Map<Long, Long>> {
        return repository.getWithCommentCountMap(bookId, page)
    }

    /**
     * コメントを新規登録します。
     */
    fun createComment(
            sentenceId: Long,
            comment: Comment
    ) {
        repository.insertComment(sentenceId, comment)
    }

    /**
     * sentenceIdから、文のリストを取得します。
     *
     * @return 文のリスト
     */
    fun getSentenceBySentenceId(
            sentenceId: Long,
            page: Page
    ): Sentence {
        return repository.getSentencesBySentenceId(sentenceId, page)
    }

    fun getTotalSentenceAmount(bookId: Long): Int {
        return repository.getTotalSentenceAmount(bookId)
    }

    fun getTotalCommentAmount(sentenceId: Long): Int {
        return repository.getTotalCommentAmount(sentenceId)
    }

}