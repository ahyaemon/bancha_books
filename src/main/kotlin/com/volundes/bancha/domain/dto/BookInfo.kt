package com.volundes.bancha.domain.dto

data class BookInfo(
    val bookId: Long?,
    val name: String,
    val author: String,
    val isbn: String
)