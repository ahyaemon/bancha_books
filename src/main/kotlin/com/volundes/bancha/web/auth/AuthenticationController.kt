package com.volundes.bancha.web.auth

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

/**
 * TODO 使ってなかったら消す。auth/loginへ直接マッピングするようConfigを修正？
 */
@Controller
@RequestMapping("/")
class AuthenticationController(
) {

    @RequestMapping("/login")
    fun index(model: Model): String{
        return "auth/login"
    }

}