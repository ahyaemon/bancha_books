package com.volundes.bancha.domain.obj.book

data class BookInfo(
        val id: Long?,
        val title: String,
        val author: Author,
        val license: License?
)
