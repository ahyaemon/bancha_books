package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.Book

class BookItem(
        var bookId: Long?,
        var name: String,
        var author: String
) {
    constructor(book: Book): this(book.bookId, book.name, book.author)
}