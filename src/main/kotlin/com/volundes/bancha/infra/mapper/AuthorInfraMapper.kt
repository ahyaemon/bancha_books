package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.book.Author
import com.volundes.bancha.infra.entity.AuthorEntity
import org.springframework.stereotype.Component

@Component
class AuthorInfraMapper{

    fun toAuthorEntity(author: Author): AuthorEntity{
        val entity = AuthorEntity()
        entity.name  = author.name
        return entity
    }

}