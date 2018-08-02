package com.volundes.bancha.web.admin.updatebook

import com.volundes.bancha.domain.book.BookInfo

class UpdateBookItem(
        val bookId: Long?,
        val name: String,
        val author: String
){
    constructor(bookInfo: BookInfo): this(bookInfo.bookId, bookInfo.name, bookInfo.author)
}