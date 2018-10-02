package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.`object`.book.Comment
import com.volundes.bancha.infra.entity.table.CommentTable

interface CommentMapperExtension{

    fun Comment.toEntity(sentenceId: Long): CommentTable {
        val entity = CommentTable()
        entity.id = id
        entity.sentenceId = sentenceId
        entity.accountId = accountId
        entity.comment = comment
        return entity
    }

}