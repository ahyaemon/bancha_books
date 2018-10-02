package com.volundes.bancha.web.admin.updatebook

import com.volundes.bancha.domain.`object`.bookmenu.BookMenu

class UpdateBookMenuItem(
        val bookId: Long?,
        val name: String,
        val author: String
){

    constructor(bookMenu: BookMenu):
            this(bookMenu.id, bookMenu.name, bookMenu.author)

}