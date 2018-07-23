package com.volundes.bancha.web.controller.admin.insertbook

import com.volundes.bancha.domain.provider.SubtitleProvider
import com.volundes.bancha.domain.service.BookMenuService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/insertbook")
class InsertBookController(
) {

    @RequestMapping("/")
    fun login(): String{
        return "admin/insertbook/index"
    }

}