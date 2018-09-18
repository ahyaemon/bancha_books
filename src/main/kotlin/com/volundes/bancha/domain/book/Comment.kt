package com.volundes.bancha.domain.book

data class Comment(
        val commentId: Long?,
        val accountId: Long,
        val name: String,
        val comment: String
)