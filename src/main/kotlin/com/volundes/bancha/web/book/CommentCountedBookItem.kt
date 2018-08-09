package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.CommentCountedBook

class CommentCountedBookItem(
        val bookId: Long?,
        val name: String,
        val author: String,
        val sentenceItems: List<CommentCountedSentenceItem>
) {
    constructor(book: CommentCountedBook):
            this(book.bookId, book.name, book.author.name, book.sentences.map{ CommentCountedSentenceItem(it) })
}