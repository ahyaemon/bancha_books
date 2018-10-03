package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.obj.book.*
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
        val license = if(entity.licenseId == null) {
            null
        } else {
            License(entity.licenseId, entity.notice, entity.licenseType)
        }
        val author = Author(entity.authorId, entity.authorName)
        val book = CommentCountedBook(entity.bookId, entity.name, author, license, sentences)
        return book
    }

    fun Book.toBookEntity(authorId: Long): BookTable {
        val entity = BookTable()
        entity.id = id
        entity.name = bookInfo.title
        entity.authorId = authorId
        return entity
    }

}