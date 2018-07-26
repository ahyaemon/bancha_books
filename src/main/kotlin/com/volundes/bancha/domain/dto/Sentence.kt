package com.volundes.bancha.domain.dto

data class Sentence(
        val sentenceId: Long?,
        val sentence: String,
        val comments: List<Comment>,
        val rubies: List<Ruby>
)