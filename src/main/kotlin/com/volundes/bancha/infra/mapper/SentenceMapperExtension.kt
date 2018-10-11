package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.obj.book.Comment
import com.volundes.bancha.domain.obj.book.Sentence
import com.volundes.bancha.infra.entity.SentenceSummaryEntity
import com.volundes.bancha.infra.entity.table.SentenceTable

interface SentenceMapperExtension{

    fun Sentence.toTable(bookId: Long) = SentenceTable(id, bookId.toInt(), sentence, heading)
    fun List<Sentence>.toTables(bookId: Long) =  map{ it.toTable(bookId) }

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