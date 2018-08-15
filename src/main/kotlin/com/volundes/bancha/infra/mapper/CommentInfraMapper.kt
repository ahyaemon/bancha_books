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
        return entity
    }

    fun toComment(entity: CommentTable): Comment {
        // TODO deleteKeyの設定
        return Comment(entity.commentId, entity.name, entity.comment, null)
    }

}