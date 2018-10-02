package com.volundes.bancha.domain.`object`.book

data class Comment(
        val id: Long?,
        val accountId: Long,
        val name: String,
        val comment: String
)