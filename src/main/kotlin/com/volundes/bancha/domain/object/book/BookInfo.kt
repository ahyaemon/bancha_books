package com.volundes.bancha.domain.`object`.book

data class BookInfo(
        val id: Long?,
        val title: String,
        val author: Author,
        val license: License?
)
