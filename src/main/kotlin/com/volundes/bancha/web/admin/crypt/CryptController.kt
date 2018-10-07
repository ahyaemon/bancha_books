package com.volundes.bancha.web.admin.crypt

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

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