package com.volundes.bancha.domain.book

data class CommentCountedBook(
    val bookId: Long?,
    val name: String,
    val author: Author,
    val sentences: List<CommentCountedSentence>
)