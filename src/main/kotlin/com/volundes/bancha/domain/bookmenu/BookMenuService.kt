package com.volundes.bancha.domain.bookmenu

import com.volundes.bancha.infra.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookMenuService(
        private val repository: BookRepository
) {

    fun getBookMenus(): List<BookMenu> {
        return repository.getBookMenus()
    }

}