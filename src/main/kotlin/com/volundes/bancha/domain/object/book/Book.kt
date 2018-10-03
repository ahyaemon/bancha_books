package com.volundes.bancha.domain.`object`.book

data class Book(
        val id: Long?,
        val bookInfo: BookInfo,
        val sentences: List<Sentence>
)