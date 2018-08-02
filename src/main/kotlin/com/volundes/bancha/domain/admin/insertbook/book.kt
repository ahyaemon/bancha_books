package com.volundes.bancha.domain.admin.insertbook

import com.volundes.bancha.domain.book.Sentence

// TODO Bookと統合する
data class book(
        val bookId: Long?,
        val name: String,
        val author: String,
        val sentences: List<Sentence>
)