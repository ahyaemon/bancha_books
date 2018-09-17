package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.book.Comment
import com.volundes.bancha.domain.book.Sentence
import com.volundes.bancha.infra.entity.SentenceSummaryEntity
import com.volundes.bancha.infra.entity.table.SentenceTable

interface SentenceMapperExtension{

    fun List<Sentence>.toSentenceEntities(bookId: Long): List<SentenceTable> {
        return map{
            val entity = SentenceTable()
            entity.bookId = bookId
            entity.sentence = it.sentence
            entity
        }
    }

    fun List<SentenceSummaryEntity>.toSentence(): Sentence {
        val firstEntity = first()
        val comments =
                if(firstEntity.commentId == null){
                    arrayListOf()
                }else{
                    map{ Comment(it.commentId, it.commentName, it.comment) }
                }
        return Sentence(firstEntity.sentenceId, firstEntity.sentence, comments)
    }

}