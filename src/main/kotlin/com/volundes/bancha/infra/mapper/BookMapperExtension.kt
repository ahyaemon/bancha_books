package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.obj.book.*
import com.volundes.bancha.infra.entity.BookEntity
import com.volundes.bancha.infra.entity.BookSummaryEntity
import com.volundes.bancha.infra.entity.table.BookTable

interface BookMapperExtension{

    fun List<BookEntity>.toBook(): Book {
        val entity = first()
        val author = Author(entity.authorId, entity.authorName)
        val license = if(entity.licenseId == null) {
            null
        }
        else {
            License(entity.licenseId, entity.licenseNotice, entity.licenseType)
        }
        val bookInfo = BookInfo(entity.bookInfoId, entity.title, author, license)
        val sentences = groupBy{ it.sentenceId }
                .map{ (sentenceId, entities) ->
                    val first = entities.first()
                    val value = first.sentenceValue
                    val heading = first.sentenceHeading.toInt()
                    val comments = entities
                            .filter{ it.commentId != null }
                            .map{
                        Comment(it.commentId, it.commentAccountId, it.commentName, it.commentValue)
                    }
                    Sentence(sentenceId, value, heading, comments)
                }
        return Book(entity.bookId, bookInfo, sentences)
    }

    fun Book.toTable(bookInfoId: Long): BookTable {
        val table = BookTable()
        table.id = id
        table.bookInfoId = bookInfoId
        return table
    }

}