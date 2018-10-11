package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.obj.book.Comment
import com.volundes.bancha.infra.entity.table.CommentTable

interface CommentMapperExtension{

    fun Comment.toEntity(sentenceId: Long) = CommentTable(id, sentenceId.toInt(), accountId.toInt(), comment)

}