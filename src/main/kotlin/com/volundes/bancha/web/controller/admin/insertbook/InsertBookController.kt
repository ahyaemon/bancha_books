package com.volundes.bancha.web.controller.admin.insertbook

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/insertbook")
class InsertBookController(
) {

    @RequestMapping("/")
    fun index(
            model: Model
    ): String{
        val htmlBookUploadForm = HtmlBookUploadForm()
        model.addAttribute("htmlBookUploadForm", htmlBookUploadForm)

        return "admin/insertbook/index"
    }

    @RequestMapping("/html")
    fun insertHtml(
            @Validated htmlBookUploadForm: HtmlBookUploadForm,
            result: BindingResult
    ): String{
        return "admin/insertbook/index"
    }

}