package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.book.Comment
import com.volundes.bancha.domain.book.Sentence
import com.volundes.bancha.infra.entity.table.SentenceTable
import com.volundes.bancha.infra.entity.SentenceSummaryEntity
import org.springframework.stereotype.Component

@Component
class SentenceInfraMapper {

    fun toSentenceEntities(bookId: Long, sentences: List<Sentence>): List<SentenceTable> {
        return sentences.map{
            val entity = SentenceTable()
            entity.bookId = bookId
            entity.sentence = it.sentence
            entity
        }
    }

    fun toSentence(sentenceSummaryEntities: List<SentenceSummaryEntity>): Sentence {
        val firstEntity = sentenceSummaryEntities.first()

        val comments =
                if(firstEntity.commentId == null){
                    arrayListOf<Comment>()
                }else{
                    sentenceSummaryEntities.map{ Comment(it.commentId, it.commentName, it.comment, null) }
                }

        return Sentence(firstEntity.sentenceId, firstEntity.sentence, comments)
    }

}