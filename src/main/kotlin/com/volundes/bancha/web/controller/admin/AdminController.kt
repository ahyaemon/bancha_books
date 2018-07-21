package com.volundes.bancha.web.controller.admin

import com.volundes.bancha.domain.provider.SubtitleProvider
import com.volundes.bancha.domain.service.BookMenuService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin")
class AdminController(
) {

    @RequestMapping("/login")
    fun login(): String{
        return "admin/login"
    }

    @RequestMapping("/menu")
    fun menu(): String{
        return "admin/menu"
    }

}