package com.volundes.bancha.web.controller.bookmenu

import com.volundes.bancha.domain.dto.BookMenu

data class BookMenuItem(
    var bookId: Long? = null,
    var name: String = "",
    var author: String = "",
    var isbn: String = ""
) {

    constructor(bookMenu: BookMenu) : this(bookMenu.bookId, bookMenu.name, bookMenu.author, bookMenu.isbn)

}