package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.book.Author
import com.volundes.bancha.domain.book.Book
import com.volundes.bancha.domain.book.CommentCountedBook
import com.volundes.bancha.domain.book.CommentCountedSentence
import com.volundes.bancha.domain.bookmenu.BookMenu
import com.volundes.bancha.infra.entity.BookMenuEntity
import com.volundes.bancha.infra.entity.BookSummaryEntity
import com.volundes.bancha.infra.entity.table.BookTable

interface BookMapperExtension{

    fun List<BookSummaryEntity>.toCommentCountedBook(): CommentCountedBook {
        val sentences = groupBy { it.sentenceId }
                .map{ (sentenceId, entities) ->
                    val entity = entities.first()
                    CommentCountedSentence(sentenceId, entity.sentence, entity.heading, entity.commentCount)
                }
        val entity = first()
        val author = Author(entity.authorId, entity.authorName)
        val book = CommentCountedBook(entity.bookId, entity.name, author, sentences)
        return book
    }

    fun BookMenuEntity.toBookMenu() =  BookMenu(bookId, name, author)
    fun List<BookMenuEntity>.toBookMenus() =  map{ it.toBookMenu() }

    fun Book.toBookEntity(authorId: Long): BookTable {
        val entity = BookTable()
        entity.bookId = bookId
        entity.name = name
        entity.authorId = authorId
        return entity
    }

}