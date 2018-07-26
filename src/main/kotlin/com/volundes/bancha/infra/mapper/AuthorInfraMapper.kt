package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.dto.InsertBook
import com.volundes.bancha.infra.entity.AuthorEntity
import org.springframework.stereotype.Component

@Component
class AuthorInfraMapper{

    fun toAuthorEntity(insertBook: InsertBook): AuthorEntity{
        val entity = AuthorEntity()
        entity.name  = insertBook.author
        return entity
    }

}