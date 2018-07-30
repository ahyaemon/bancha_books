package com.volundes.bancha.domain.service

import com.volundes.bancha.domain.dto.Book
import com.volundes.bancha.domain.dto.Comment
import com.volundes.bancha.domain.dto.Sentence
import com.volundes.bancha.domain.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
        private val repository: BookRepository
) {

    fun getSentences(bookId: String): List<Sentence> {
        return repository.getSentences(bookId)
    }

    fun getBookByBookId(bookId: String): Book {
        return repository.getBookByBookId(bookId)
    }

    fun createComment(sentenceId: Long, comment: Comment) {
        repository.insertComment(sentenceId, comment)
    }

    fun getComments(sentenceId: Long): List<Comment> {
        return repository.getCommentsBySentenceId(sentenceId)
    }

}