package com.volundes.bancha.domain.repository

import com.volundes.bancha.infra.dao.PersonDao
import com.volundes.bancha.infra.entity.PersonEntity
import com.volundes.bancha.domain.dto.Person
import com.volundes.bancha.infra.mapper.PersonInfraMapper
import org.springframework.stereotype.Repository

@Repository
class PersonRepository(
        private val mapper: PersonInfraMapper,
        private val personDao: PersonDao
) {
    fun insert(person: Person) {
        personDao.insert(mapper.toPersonEntity(person))
    }

    fun select(): List<Person> {
        return personDao.select().map { mapper.toPerson(it) }
    }

    fun update(person: Person) {
        personDao.update(mapper.toPersonEntity(person))
    }

    fun delete(person: Person) {
        personDao.delete(mapper.toPersonEntity(person))
    }
}