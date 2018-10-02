package com.volundes.bancha.domain.book

import com.volundes.bancha.domain.book.service.License

data class Book(
    val bookId: Long?,
    val name: String,
    val author: Author,
    val license: License?,
    val sentences: List<Sentence>
)