package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.book.*
import com.volundes.bancha.domain.bookmenu.BookMenu
import com.volundes.bancha.infra.entity.table.BookTable
import com.volundes.bancha.infra.entity.BookInfoEntity
import com.volundes.bancha.infra.entity.BookMenuEntity
import com.volundes.bancha.infra.entity.BookSummaryEntity
import org.springframework.stereotype.Component

@Component
class BookInfraMapper{

    fun toCommentCountedBook(entities: List<BookSummaryEntity>): CommentCountedBook{
        val sentences = entities.groupBy { it.sentenceId }
                .map{ (sentenceId, entities) ->
                    val entity = entities.first()
                    CommentCountedSentence(sentenceId, entity.sentence, entity.commentCount)
                }
        val entity = entities.first()
        val author = Author(entity.authorId, entity.authorName)
        val book = CommentCountedBook(entity.bookId, entity.name, author, sentences)
        return book
    }

    fun toBookMenu(entity: BookMenuEntity): BookMenu {
        return BookMenu(entity.bookId, entity.name, entity.author)
    }

    fun toBookEntity(book: Book, authorId: Long): BookTable {
        val entity = BookTable()
        entity.bookId = book.bookId
        entity.name = book.name
        entity.authorId = authorId

        return entity
    }

    fun toBookInfo(entity: BookInfoEntity): BookInfo {
        return BookInfo(entity.bookId, entity.name, entity.author)
    }

    fun toBookInfos(entities: List<BookInfoEntity>): List<BookInfo> {
        return entities.map{ toBookInfo(it) }
    }

}