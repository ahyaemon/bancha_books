package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.book.Author
import com.volundes.bancha.infra.entity.table.AuthorTable

interface AuthorMapperExtension {

    fun Author.toAuthorEntity(): AuthorTable {
        val entity = AuthorTable()
        entity.name  = name
        return entity
    }

}