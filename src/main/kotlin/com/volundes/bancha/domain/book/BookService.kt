package com.volundes.bancha.domain.book

import com.volundes.bancha.infra.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
        private val repository: BookRepository
) {

    fun getCommentCountedBookByBookId(bookId: Long): CommentCountedBook {
        return repository.getCommentCountedBookByBookId(bookId)
    }

    fun createComment(sentenceId: Long, comment: Comment) {
        repository.insertComment(sentenceId, comment)
    }

    fun getSentenceBySentenceId(sentenceId: Long): Sentence {
        return repository.getSentencesBySentenceId(sentenceId)
    }

}