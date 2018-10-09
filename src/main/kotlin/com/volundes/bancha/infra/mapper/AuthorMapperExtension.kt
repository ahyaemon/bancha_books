package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.obj.book.Author
import com.volundes.bancha.infra.entity.table.AuthorTable

interface AuthorMapperExtension {

    fun Author.toAuthorEntity() = AuthorTable(id, name)
    fun AuthorTable.toAuthor() = Author(id, name)

}