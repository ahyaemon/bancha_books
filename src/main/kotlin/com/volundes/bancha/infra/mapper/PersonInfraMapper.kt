package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.dto.Person
import com.volundes.bancha.infra.entity.PersonEntity
import org.springframework.stereotype.Component

@Component
class PersonInfraMapper{
    fun toPersonEntity(person: Person): PersonEntity {
        var entity = PersonEntity()
        entity.personId = person.personId
        entity.name = person.name
        entity.comment = person.comment
        return entity
    }

    fun toPerson(entity: PersonEntity): Person{
        return Person(entity.personId, entity.name, entity.comment)
    }
}