package com.volundes.bancha.domain.`object`.book

data class Sentence(
        val sentenceId: Long?,
        val sentence: String,
        val heading: Int,
        val comments: List<Comment>
)