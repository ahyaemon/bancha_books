package com.volundes.bancha.domain.general.login

import com.volundes.bancha.domain.mail.RegisterMail
import com.volundes.bancha.domain.mail.RegisterMailer
import com.volundes.bancha.infra.repository.AccountRegisterRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GeneralLoginService(
        private val registerMail: RegisterMail,
        private val registerMailer: RegisterMailer,
        private val accountRegisterRepository: AccountRegisterRepository
) {

    /**
     * ・メールの送信
     * ・registerMailInfoをDB(account_registerテーブル)に登録
     */
    fun sendRegisterMail(mailAddress: String) {
        // メールの送信
        val mail = registerMail.createEmail(mailAddress)
        val mailer = registerMailer.createMailer()
//        mailer.sendMail(mail)

        // DBに登録
        val accountRegister = AccountRegister(null, "sht.ijm0011@gmail.com", "testurl", LocalDateTime.now())
        accountRegisterRepository.addAccountRegister(accountRegister)

    }

}