package com.volundes.bancha.web.admin.updatebook

import com.volundes.bancha.domain.`object`.book.BookInfo

class UpdateBookMenuItem(
        val bookId: Long?,
        val title: String,
        val author: String
){

    constructor(bookInfo: BookInfo):
            this(bookInfo.id, bookInfo.title, bookInfo.author.name)

}