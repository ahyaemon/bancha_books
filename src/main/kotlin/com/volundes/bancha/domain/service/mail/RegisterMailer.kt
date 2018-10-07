package com.volundes.bancha.domain.service.mail

import com.volundes.bancha.env.setting.SmtpSettings
import org.simplejavamail.mailer.Mailer
import org.simplejavamail.mailer.MailerBuilder
import org.simplejavamail.mailer.config.TransportStrategy
import org.springframework.stereotype.Component

@Component
class RegisterMailer(
        private val smtpSettings: SmtpSettings
) {

    val host = "smtp.gmail.com"
    val port = 465
    val user = "banchabooks@gmail.com"
    val password = smtpSettings.password
    val strategy = TransportStrategy.SMTPS

    fun createMailer(): Mailer {
        return MailerBuilder
                .withSMTPServer(
                        host,
                        port,
                        user,
                        password
                )
                .withTransportStrategy(strategy)
                .buildMailer()
    }

}