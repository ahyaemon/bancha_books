package com.volundes.bancha.domain.service

import com.volundes.bancha.domain.dto.Book
import com.volundes.bancha.domain.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class UpdateBookService(
        private val repository: BookRepository
) {

    fun getBooks(): List<Book> {
        return repository.getBooks()
    }

}