package com.volundes.bancha.web.controller.auth

import com.volundes.bancha.domain.provider.SubtitleProvider
import com.volundes.bancha.domain.service.BookMenuService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class AuthenticationController(
) {

    @RequestMapping("/login")
    fun index(model: Model): String{
        return "auth/login"
    }

}