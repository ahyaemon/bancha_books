package com.volundes.bancha.domain.book

data class CommentCountedSentence(
        val sentenceId: Long?,
        val sentence: String,
        val commentCount: Long
)