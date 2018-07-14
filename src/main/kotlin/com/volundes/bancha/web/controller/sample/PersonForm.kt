package com.volundes.bancha.web.controller.sample

import com.volundes.bancha.domain.dto.Person
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class PersonForm(
    var personId: Long? = null,

    @get:NotBlank
    @get:Size(max = 255)
    var name: String = "",

    var comment: String = ""
){
    constructor(person: Person): this(person.personId, person.name, person.comment)
    fun toPerson(): Person{ return Person(personId, name, comment) }
}
