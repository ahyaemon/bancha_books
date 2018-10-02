package com.volundes.bancha.domain.`object`.book

data class Sentence(
        val id: Long?,
        val sentence: String,
        val heading: Int,
        val comments: List<Comment>
)