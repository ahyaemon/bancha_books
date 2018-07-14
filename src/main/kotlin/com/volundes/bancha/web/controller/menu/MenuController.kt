package com.volundes.bancha.web.controller.menu

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class MenuController {
    @RequestMapping("")
    fun index(): String{
        return "menu/index"
    }
}