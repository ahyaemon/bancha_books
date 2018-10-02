package com.volundes.bancha.domain.service.book

import com.volundes.bancha.domain.`object`.book.Comment
import com.volundes.bancha.domain.`object`.book.CommentCountedBook
import com.volundes.bancha.domain.`object`.book.Sentence
import com.volundes.bancha.domain.`object`.paging.Page
import com.volundes.bancha.infra.repository.BookRepository
import org.springframework.stereotype.Service

/**
 * 本の管理を担うサービスです。
 */
@Service
class BookService(
        private val repository: BookRepository
) {

    fun getCommentCountedBookByBookId(
            bookId: Long,
            page: Page
    ): CommentCountedBook {
        return repository.getCommentCountedBookByBookId(bookId, page)
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