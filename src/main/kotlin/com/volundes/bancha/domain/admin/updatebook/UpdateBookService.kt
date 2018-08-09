package com.volundes.bancha.domain.admin.updatebook

import com.volundes.bancha.domain.book.CommentCountedBook
import com.volundes.bancha.domain.bookmenu.BookMenu
import com.volundes.bancha.infra.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class UpdateBookService(
        private val repository: BookRepository
) {

    fun getUpdateBookMenus(): List<BookMenu>{
        return repository.getBookMenus()
    }

    fun getCommentCountedBookByBookId(bookId: Long): CommentCountedBook {
        return repository.getCommentCountedBookByBookId(bookId)
    }

}