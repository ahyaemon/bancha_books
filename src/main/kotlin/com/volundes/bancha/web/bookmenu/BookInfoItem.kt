package com.volundes.bancha.web.bookmenu

import com.volundes.bancha.domain.`object`.book.BookInfo

data class BookInfoItem(
        var bookId: Long? = null,
        var title: String = "",
        var author: String = ""
) {

    constructor(bookInfo: BookInfo) : this(bookInfo.id, bookInfo.title, bookInfo.author.name)

}