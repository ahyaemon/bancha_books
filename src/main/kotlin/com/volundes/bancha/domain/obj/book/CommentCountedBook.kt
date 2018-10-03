package com.volundes.bancha.domain.obj.book

data class CommentCountedBook(
        val id: Long?,
        val name: String,
        val author: Author,
        val license: License?,
        val sentences: List<CommentCountedSentence>
)