package com.volundes.bancha.web.controller.book

import com.volundes.bancha.domain.dto.BookInfo

class BookItem(
        var bookId: Long?,
        var name: String,
        var author: String,
        var isbn: String
) {
    constructor(bookInfo: BookInfo): this(bookInfo.bookId, bookInfo.name, bookInfo.author, bookInfo.isbn)
}