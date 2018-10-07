package com.volundes.bancha.domain.obj.book

data class Sentence(
        val id: Long?,
        val sentence: String,
        val heading: Int,
        val comments: List<Comment>
)