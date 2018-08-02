package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.Book

class BookItem(
        val bookId: Long?,
        val name: String,
        val author: String,
        val sentenceItems: List<SentenceItem>
) {
    constructor(book: Book):
            this(book.bookId, book.name, book.author.name, book.sentences.map{ SentenceItem(it) })
}