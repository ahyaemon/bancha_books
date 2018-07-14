package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.dto.Book
import com.volundes.bancha.domain.dto.BookInfo
import com.volundes.bancha.domain.dto.BookMenu
import com.volundes.bancha.infra.entity.BookEntity
import org.springframework.stereotype.Component

@Component
class BookInfraMapper{
    fun toBookEntity(book: Book): BookEntity {
        var entity = BookEntity()
        entity.bookId = book.bookId
        entity.name = book.name
        entity.author = book.author
        entity.isbn = book.isbn
        return entity
    }

    fun toBook(entity: BookEntity): Book{
        return Book(entity.bookId, entity.name, entity.author, entity.isbn)
    }

    fun toBookMenu(entity: BookEntity): BookMenu {
        return BookMenu(entity.bookId, entity.name, entity.author, entity.isbn)
    }

    fun toBookInfo(entity: BookEntity): BookInfo {
        return BookInfo(entity.bookId, entity.name, entity.author, entity.isbn)
    }
}