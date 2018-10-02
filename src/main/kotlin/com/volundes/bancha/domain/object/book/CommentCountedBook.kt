package com.volundes.bancha.domain.`object`.book

data class CommentCountedBook(
        val id: Long?,
        val name: String,
        val author: Author,
        val license: License?,
        val sentences: List<CommentCountedSentence>
)