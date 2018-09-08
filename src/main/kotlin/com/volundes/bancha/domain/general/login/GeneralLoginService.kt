package com.volundes.bancha.domain.general.login

import com.volundes.bancha.domain.mail.RegisterMail
import com.volundes.bancha.domain.mail.RegisterMailer
import org.simplejavamail.email.EmailBuilder
import org.simplejavamail.mailer.MailerBuilder
import org.simplejavamail.mailer.config.TransportStrategy
import org.springframework.stereotype.Service

@Service
class GeneralLoginService(
        private val registerMail: RegisterMail,
        private val registerMailer: RegisterMailer
) {

    fun sendRegisterMail(mailAddress: String) {
        val mail = registerMail.createEmail(mailAddress)
        val mailer = registerMailer.createMailer()
        mailer.sendMail(mail)
    }

}