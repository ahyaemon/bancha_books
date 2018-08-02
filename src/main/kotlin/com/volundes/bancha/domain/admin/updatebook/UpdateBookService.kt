package com.volundes.bancha.domain.admin.updatebook

import com.volundes.bancha.domain.book.BookInfo
import com.volundes.bancha.infra.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class UpdateBookService(
        private val repository: BookRepository
) {

    fun getBookInfos(): List<BookInfo> {
        return repository.getBookInfos();
    }

}