package com.volundes.bancha.domain.`object`.book

data class CommentCountedSentence(
        val id: Long?,
        val sentence: String,
        val heading: Int,
        val commentCount: Long
)