package com.volundes.bancha.web.admin

import com.volundes.bancha.domain.admin.AdminService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import java.io.BufferedOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import javax.servlet.http.HttpServletResponse

/**
 * 「管理メニュー」画面を担うControllerです。
 */
@Controller
@RequestMapping("/admin")
class AdminController(
        private val service: AdminService
) {

    /**
     * loginへのマッピングです。
     * 管理者としてログインしていないときに管理者用機能にアクセスすると、
     * Spring Securityの機能によりloginにマッピングされます。
     */
    @RequestMapping("/login")
    fun login(): String {
        return "admin/login"
    }

    /**
     * 管理者用メニューへのマッピングです。
     */
    @RequestMapping("/menu")
    fun menu(): String {
        return "admin/menu"
    }

}