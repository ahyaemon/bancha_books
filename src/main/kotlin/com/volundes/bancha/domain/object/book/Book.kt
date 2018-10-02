package com.volundes.bancha.domain.`object`.book

data class Book(
        val id: Long?,
        val name: String,
        val author: Author,
        val license: License?,
        val sentences: List<Sentence>
)