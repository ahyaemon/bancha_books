package com.volundes.bancha.domain.admin.insertbook

import com.volundes.bancha.domain.book.Author
import com.volundes.bancha.domain.book.Book
import com.volundes.bancha.domain.book.Sentence
import com.volundes.bancha.infra.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class InsertBookService(
        private val bookRepository: BookRepository
) {

    fun addBook(rawBook: RawBook){
        val parser = RawBookParser(rawBook)

        val title = parser.getTitle()
        val author = Author(null, parser.getAuthor())
        val sentences = parser
                .getSentences()
                .map{
                    Sentence(null, it, listOf())
                }
        val book = Book(null, title, author, sentences)
        bookRepository.addBook(book)

    }

}