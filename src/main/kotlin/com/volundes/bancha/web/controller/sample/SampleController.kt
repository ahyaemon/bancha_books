package com.volundes.bancha.web.controller.sample

import com.volundes.bancha.domain.dto.Person
import com.volundes.bancha.domain.service.SampleService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/sample")
class SampleController(
        private val sampleService: SampleService
){

    @RequestMapping("/")
    fun index(
            @ModelAttribute personForm: PersonForm,
            model: Model
    ): String{
        val persons: List<Person> = sampleService.getPersons()
        val personForms: List<PersonForm> = persons.map { PersonForm(it) }
        model.addAttribute("personForms", personForms)
        return "sample/index"
    }

    @RequestMapping("/insert")
    fun insert(
            @Validated personForm: PersonForm,
            result: BindingResult,
            model: Model
    ): String{
        if(result.hasErrors()){
            println(result)
            return index(personForm, model)
        }
        sampleService.add(personForm.toPerson())
        return "redirect:/sample/"
    }

    @RequestMapping("/update")
    fun update(
            personForm: PersonForm
    ): String{
        sampleService.update(personForm.toPerson())
        return "redirect:/sample/"
    }

    @RequestMapping("/delete")
    fun delete(
            personForm: PersonForm
    ): String{
        sampleService.delete(personForm.toPerson())
        return "redirect:/sample/"
    }
}

