package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.`object`.book.Comment
import com.volundes.bancha.domain.`object`.book.Sentence
import com.volundes.bancha.infra.entity.SentenceSummaryEntity
import com.volundes.bancha.infra.entity.table.SentenceTable

interface SentenceMapperExtension{

    fun Sentence.toTable(bookId: Long): SentenceTable {
        val entity = SentenceTable()
        entity.bookId = bookId
        entity.sentence = sentence
        entity.heading = heading
        return entity
    }

    fun List<Sentence>.toTables(bookId: Long): List<SentenceTable> {
        return map{ it.toTable(bookId) }
    }

    fun List<SentenceSummaryEntity>.toSentence(): Sentence {
        val firstEntity = first()
        val comments =
                if(firstEntity.commentId == null){
                    arrayListOf()
                }else{
                    map{ Comment(it.commentId, it.accountId, it.commentName, it.comment) }
                }
        return Sentence(firstEntity.sentenceId, firstEntity.sentence, firstEntity.heading, comments)
    }

}