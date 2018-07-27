package com.volundes.bancha.web.controller.book

import com.volundes.bancha.domain.dto.Book

class BookItem(
        var bookId: Long?,
        var name: String,
        var author: String
) {
    constructor(book: Book): this(book.bookId, book.name, book.author)
}