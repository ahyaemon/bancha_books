package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.book.Comment
import com.volundes.bancha.infra.entity.CommentEntity
import org.springframework.stereotype.Component

@Component
class CommentInfraMapper {

    fun toEntity(sentenceId: Long, comment: Comment): CommentEntity {
        val entity = CommentEntity()
        entity.commentId = comment.commentId
        entity.sentenceId = sentenceId
        entity.name = comment.commentName
        entity.comment = comment.comment
        return entity
    }

}