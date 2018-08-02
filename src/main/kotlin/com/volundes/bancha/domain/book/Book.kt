package com.volundes.bancha.domain.book

data class Book(
    val bookId: Long?,
    val name: String,
    val author: Author,
    val sentences: List<Sentence>
)