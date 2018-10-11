package com.volundes.bancha.web.general.login

import com.volundes.bancha.domain.service.general.login.GeneralLoginService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/general")
class GeneralLoginController(
        private val service: GeneralLoginService
) {

    /**
     * ログインフォームへのマッピングです。
     */
    @RequestMapping("/login")
    fun login(
            model: Model
    ): String {
        model.addAttribute("generalRegisterForm", GeneralRegisterForm(""))
        return "general/login/index"
    }

    /**
     * 新規ユーザー登録処理です。
     * 登録ページへのメールを送信します。
     */
    @RequestMapping("/sendmail")
    fun sendmail(
            generalRegisterForm: GeneralRegisterForm
    ): String {
        service.sendRegisterMail(generalRegisterForm.email)
        return "general/login/sendmail"
    }

}