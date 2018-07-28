package com.volundes.bancha.web.controller.admin

import com.volundes.bancha.domain.provider.SubtitleProvider
import com.volundes.bancha.domain.service.BookMenuService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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

    @RequestMapping("/download/restore")
    fun downloadRestoreFiles(): ResponseEntity<ByteArray>{
        val h = HttpHeaders()
        h.add("Content-Type", "text/csv; charset=MS932")
        h.setContentDispositionFormData("filename",  "test.csv");
        val s = "test"
        return ResponseEntity(s.toByteArray(), h, HttpStatus.OK)
    }
}