package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.book.*
import com.volundes.bancha.domain.bookmenu.BookMenu
import com.volundes.bancha.infra.entity.BookEntity
import com.volundes.bancha.infra.entity.BookInfoEntity
import com.volundes.bancha.infra.entity.BookMenuEntity
import com.volundes.bancha.infra.entity.BookSummaryEntity
import org.springframework.stereotype.Component

@Component
class BookInfraMapper{

    fun toBook(entities: List<BookSummaryEntity>): Book{
        val sentences = entities.groupBy { it.sentenceId }
                .map{ (sentenceId, entities) ->
                    // コメントが無い場合は、空のリスト
                    val comments = entities.filter{ it.commentId != null }
                            .map{ Comment(it.commentId, it.commentName, it.comment) }
                    val entity = entities.first()
                    Sentence(sentenceId, entity.sentence, comments)
                }
        val entity = entities.first()
        val author = Author(entity.authorId, entity.authorName)
        val book = Book(entity.bookId, entity.name, author, sentences)
        return book
    }

    fun toBookMenu(entity: BookMenuEntity): BookMenu {
        return BookMenu(entity.bookId, entity.name, entity.author)
    }

    fun toBookEntity(book: Book, authorId: Long): BookEntity {
        val entity = BookEntity()
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