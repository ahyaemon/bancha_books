package com.volundes.bancha.domain.`object`.admin.insertbook

import com.volundes.bancha.domain.`object`.book.Sentence

// TODO Bookと統合する
data class book(
        val id: Long?,
        val name: String,
        val author: String,
        val sentences: List<Sentence>
)