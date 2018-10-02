package com.volundes.bancha.web.bookmenu

import com.volundes.bancha.domain.`object`.bookmenu.BookMenu

data class BookMenuItem(
    var bookId: Long? = null,
    var name: String = "",
    var author: String = ""
) {

    constructor(bookMenu: BookMenu) : this(bookMenu.id, bookMenu.name, bookMenu.author)

}