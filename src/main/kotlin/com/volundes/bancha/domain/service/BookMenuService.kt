package com.volundes.bancha.domain.service

import com.volundes.bancha.domain.dto.BookMenu
import com.volundes.bancha.domain.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookMenuService(
        private val repository: BookRepository
) {

    fun getBookMenus(): List<BookMenu> {
        return repository.getBookMenus()
    }

}