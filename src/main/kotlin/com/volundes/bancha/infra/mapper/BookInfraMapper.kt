package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.dto.Book
import com.volundes.bancha.domain.dto.BookMenu
import com.volundes.bancha.domain.dto.InsertBook
import com.volundes.bancha.infra.entity.BookEntity
import com.volundes.bancha.infra.entity.InsertBookEntity
import org.springframework.stereotype.Component

@Component
class BookInfraMapper{
    fun toBookEntity(book: Book): BookEntity {
        var entity = BookEntity()
        entity.bookId = book.bookId
        entity.name = book.name
        entity.author = book.author
        return entity
    }

    fun toBookEntity(book: InsertBook): BookEntity{
        val entity = BookEntity()
        entity.bookId = book.bookId
        entity.name = book.name
        entity.author = book.author
        return entity
    }

    fun toBook(entity: BookEntity): Book{
        return Book(entity.bookId, entity.name, entity.author)
    }

    fun toBook(entities: List<BookEntity>): List<Book> {
        return entities.map{ toBook(it) }
    }

    fun toBookMenu(entity: BookEntity): BookMenu {
        return BookMenu(entity.bookId, entity.name, entity.author)
    }

    fun toInsertBookEntity(insertBook: InsertBook, authorId: Long): InsertBookEntity {
        val entity = InsertBookEntity()
        entity.bookId = insertBook.bookId
        entity.name = insertBook.name
        entity.authorId = authorId

        return entity
    }

}