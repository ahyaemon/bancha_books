package com.volundes.bancha.domain.obj.book

data class Book(
        val id: Long?,
        val bookInfo: BookInfo,
        val sentences: List<Sentence>
)