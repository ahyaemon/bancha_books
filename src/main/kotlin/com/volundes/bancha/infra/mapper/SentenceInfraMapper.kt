package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.dto.Comment
import com.volundes.bancha.domain.dto.Ruby
import com.volundes.bancha.domain.dto.Sentence
import com.volundes.bancha.infra.entity.BookSummaryEntity
import com.volundes.bancha.infra.entity.CommentEntity
import com.volundes.bancha.infra.entity.SentenceEntity
import org.springframework.stereotype.Component

@Component
class SentenceInfraMapper {

    fun toSentences(summaries: List<BookSummaryEntity>): List<Sentence>{
        return summaries
                .groupBy { it.sentenceId }
                .map{
                    val entities = it.value
                    val first = entities[0]
                    val comments: List<Comment> = entities
                            .filter{ it.commentId != null }
                            .map{ Comment(it.commentId, it.commentName, it.comment) }
                            .sortedBy{ it.commentId }
                    val rubies: List<Ruby> = entities
                            .filter{ it.rubyId != null }
                            .map{ Ruby(it.rubyId, it.kanji, it.ruby) }
                            .sortedBy{ it.rubyId }
                    Sentence(first.sentenceId, first.sentence, comments, rubies)
                }
                .sortedBy { it.sentenceId }
    }

    fun toComment(entities: List<CommentEntity>): List<Comment> {
        return entities.map{ Comment(it.commentId, it.name, it.comment) }
    }

    fun toSentenceEntities(bookId: Long, sentences: List<Sentence>): List<SentenceEntity> {
        return sentences.map{
            val entity = SentenceEntity()
            entity.bookId = bookId
            entity.sentence = it.sentence
            entity
        }
    }

}