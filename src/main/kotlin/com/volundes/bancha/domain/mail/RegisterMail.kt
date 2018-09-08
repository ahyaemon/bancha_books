package com.volundes.bancha.domain.mail

import org.simplejavamail.email.Email
import org.simplejavamail.email.EmailBuilder
import org.springframework.stereotype.Component

@Component
class RegisterMail {

    val sender = "banchabooks@gmail.com"
    val subject = "【 banchabooks 】会員登録 - メールアドレスのご確認"
    val text = """
こんにちは。
会員登録ページはこちら
⇒　まだできてないよ

もしこのメールに覚えがない場合は無視してください。
"""

    fun createEmail(toMailAddress: String): Email {
        return EmailBuilder.startingBlank()
                .to(toMailAddress)
                .from(sender)
                .withSubject(subject)
                .withPlainText(text)
                .buildEmail()
    }

}