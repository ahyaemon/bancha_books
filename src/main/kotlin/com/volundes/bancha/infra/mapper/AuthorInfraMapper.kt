package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.book.Author
import com.volundes.bancha.infra.entity.table.AuthorTable
import org.springframework.stereotype.Component

@Component
class AuthorInfraMapper{

    fun toAuthorEntity(author: Author): AuthorTable {
        val entity = AuthorTable()
        entity.name  = author.name
        return entity
    }

}