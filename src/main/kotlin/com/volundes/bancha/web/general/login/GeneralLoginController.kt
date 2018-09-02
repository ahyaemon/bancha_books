package com.volundes.bancha.web.general.login

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/general/login")
class GeneralLoginController {

    @RequestMapping
    fun index(): String{
        return "general/login/index"
    }
}