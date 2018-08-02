package com.volundes.bancha.domain.book

import com.volundes.bancha.infra.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
        private val repository: BookRepository
) {

    fun getBookByBookId(bookId: Long): Book {
        return repository.getBookByBookId(bookId)
    }

    fun createComment(sentenceId: Long, comment: Comment) {
        repository.insertComment(sentenceId, comment)
    }

    fun getComments(sentenceId: Long): List<Comment> {
        return repository.getCommentsBySentenceId(sentenceId)
    }

}