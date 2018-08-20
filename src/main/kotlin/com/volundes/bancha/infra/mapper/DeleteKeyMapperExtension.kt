package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.book.Comment
import com.volundes.bancha.infra.entity.table.DeleteKeyTable

interface DeleteKeyMapperExtension {

    fun Comment.toDeleteKeyEntity(commentId: Long): DeleteKeyTable {
        val entity = DeleteKeyTable()
        entity.commentId = commentId
        entity.deleteKey = deleteKey
        return entity
    }

}