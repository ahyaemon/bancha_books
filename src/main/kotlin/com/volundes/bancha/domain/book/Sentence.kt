package com.volundes.bancha.domain.book

data class Sentence(
        val sentenceId: Long?,
        val sentence: String,
        val comments: List<Comment>,
        val rubies: List<Ruby>
)