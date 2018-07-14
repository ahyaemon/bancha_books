package com.volundes.bancha.domain.service

import com.volundes.bancha.domain.repository.PersonRepository
import com.volundes.bancha.domain.dto.Person
import org.springframework.stereotype.Service

@Service
class SampleService(
    private val personRepository: PersonRepository
) {
    fun add(person: Person) {
        personRepository.insert(person)
    }

    fun getPersons(): List<Person> {
        return personRepository.select()
    }

    fun update(person: Person) {
        personRepository.update(person)
    }

    fun delete(person: Person) {
        personRepository.delete(person)
    }
}