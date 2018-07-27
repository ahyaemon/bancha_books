package com.volundes.bancha.domain.dto

// TODO Bookと統合する
data class InsertBook(
        val bookId: Long?,
        val name: String,
        val author: String,
        val sentences: List<Sentence>
)