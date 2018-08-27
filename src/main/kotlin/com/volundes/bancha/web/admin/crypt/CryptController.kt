package com.volundes.bancha.web.admin.crypt

import com.volundes.bancha.domain.admin.AdminService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.io.BufferedOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import javax.servlet.http.HttpServletResponse

/**
 * 「暗号化の確認」画面を担うControllerです。
 */
@Controller
@RequestMapping("/admin/crypt")
class CryptController() {

    /**
     * indexへのマッピングです。
     */
    @RequestMapping
    fun login(): String {
        return "admin/crypt/index"
    }

    /**
     * ajax
     * 受け取った plainText を、暗号化して返します。
     */
    @RequestMapping("/encrypt")
    @ResponseBody
    fun encrypt(
            @RequestBody encryptForm: EncryptForm
    ): String {
        return BCryptPasswordEncoder().encode(encryptForm.plainText)
    }

}