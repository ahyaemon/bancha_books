package com.volundes.bancha.domain.`object`.book

data class Book(
        val bookId: Long?,
        val name: String,
        val author: Author,
        val license: License?,
        val sentences: List<Sentence>
)