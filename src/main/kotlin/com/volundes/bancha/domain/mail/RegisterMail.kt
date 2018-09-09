package com.volundes.bancha.domain.mail

import org.simplejavamail.email.Email
import org.simplejavamail.email.EmailBuilder
import org.springframework.stereotype.Component

@Component
class RegisterMail {

    val sender = "banchabooks@gmail.com"
    val subject = "【 banchabooks 】会員登録 - メールアドレスのご確認"
    val text = """
こんにちは！！
banchabooks管理人のあひゃもんです。

こちらのページから会員登録をお願いします。
https://banchabooks.herokuapp.com/thank-you-for-register/%s

もしこのメールに覚えがない場合は無視してください。

※このメールに返信しても、たまにしか確認しません。
"""

    fun createEmail(toMailAddress: String, urlKey: String): Email {
        return EmailBuilder.startingBlank()
                .to(toMailAddress)
                .from(sender)
                .withSubject(subject)
                .withPlainText(text.format(urlKey))
                .buildEmail()
    }

}