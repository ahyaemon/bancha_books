package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.book.Comment
import com.volundes.bancha.infra.entity.table.CommentTable
import org.springframework.stereotype.Component

@Component
class CommentInfraMapper {

    fun toEntity(sentenceId: Long, comment: Comment): CommentTable {
        val entity = CommentTable()
        entity.commentId = comment.commentId
        entity.sentenceId = sentenceId
        entity.name = comment.name
        entity.comment = comment.comment
        entity.canDelete = comment.hasDeleteKey
        entity.deleteKey = comment.deleteKey
        return entity
    }

    fun toComment(entity: CommentTable): Comment {
        return Comment(entity.commentId, entity.name, entity.comment, entity.canDelete, entity.deleteKey)
    }

}