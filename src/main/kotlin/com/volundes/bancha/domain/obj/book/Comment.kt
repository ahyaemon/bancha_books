package com.volundes.bancha.domain.obj.book

data class Comment(
        val id: Long?,
        val accountId: Long,
        val name: String,
        val comment: String
)