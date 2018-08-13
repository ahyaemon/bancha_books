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
        entity.name = comment.name
        entity.comment = comment.comment
        entity.canDelete = comment.hasDeleteKey
        entity.deleteKey = comment.deleteKey
        return entity
    }

}