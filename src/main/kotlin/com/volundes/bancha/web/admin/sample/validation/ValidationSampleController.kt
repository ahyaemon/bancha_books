package com.volundes.bancha.web.admin.sample.validation

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/sample/validation")
class ValidationSampleController {

    @RequestMapping
    fun index(): String {
        return "admin/sample/validation/index"
    }

}