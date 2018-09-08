package com.volundes.bancha.domain.general.login

import org.simplejavamail.email.EmailBuilder
import org.simplejavamail.mailer.MailerBuilder
import org.simplejavamail.mailer.config.TransportStrategy
import org.springframework.stereotype.Service

@Service
class GeneralLoginService {

    fun sendRegisterMail(mailAddress: String) {
        val mail = EmailBuilder.startingBlank()
                .to("me", "sht.ijm0011@gmail.com")
                .from("banchabooks@gmail.com")
                .withSubject("テストメールの送信です。")
                .withPlainText("メール送信ができている？")
                .buildEmail()

        val mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 465, "banchabooks@gmail.com", "ohaio98polish?gakumon")
                .withTransportStrategy(TransportStrategy.SMTPS)
                .withDebugLogging(true)
                .buildMailer()

        mailer.sendMail(mail)
    }

}