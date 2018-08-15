package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.book.Comment
import com.volundes.bancha.infra.entity.table.DeleteKeyTable
import org.springframework.stereotype.Component

@Component
class DeleteKeyInfraMapper {

    fun toEntity(commentId: Long, comment: Comment): DeleteKeyTable {
        val entity = DeleteKeyTable()
        entity.commentId = commentId
        entity.deleteKey = comment.deleteKey
        return entity
    }

}