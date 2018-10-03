package com.volundes.bancha.domain.service.general.login

import com.volundes.bancha.domain.obj.general.login.AccountRegister
import com.volundes.bancha.domain.obj.mail.RegisterMail
import com.volundes.bancha.domain.service.mail.RegisterMailer
import com.volundes.bancha.infra.repository.AccountRegisterRepository
import org.springframework.stereotype.Service
import java.security.MessageDigest
import java.time.LocalDateTime
import java.util.*

@Service
class GeneralLoginService(
        private val registerMail: RegisterMail,
        private val registerMailer: RegisterMailer,
        private val accountRegisterRepository: AccountRegisterRepository
) {

    /**
     * ・メールの送信
     * ・registerMailInfoをDB(account_registerテーブル)に登録
     *
     * TODO 既にDBにメールアドレスがある場合はUpdateする
     * TODO キーがDBにある場合は再作成する
     */
    fun sendRegisterMail(email: String) {
        // 登録用のURLのキー
        val urlKey = createUrlKey()

        val mail = registerMail.createEmail(email, urlKey)
        val mailer = registerMailer.createMailer()
       mailer.sendMail(mail)

        // DBに登録
        val accountRegister = AccountRegister(null, email, urlKey, LocalDateTime.now())
        accountRegisterRepository.addAccountRegister(accountRegister)

    }

    /**
     * 現在時刻をベースとして使う
     * ↑に乱数3桁を足してSHA256 * (20 + 10)
     * BASE64エンコード
     * 30桁抜き出す
     */
    private fun createUrlKey(): String {
        val rand = Random()
        val n = rand.nextInt(20) + 10
        val md = MessageDigest.getInstance("SHA-256")
        var urlKey = ""
        for(i in 0..n){
            val term = rand.nextInt(1000).toString()
            urlKey += term

            val byteArray = md.digest(urlKey.toByteArray())
            urlKey = byteArray
                    .map{ String.format("%02x", it) }
                    .fold(""){ a, b ->
                        a + b
                    }
        }
        val b = Base64.getEncoder().encodeToString(urlKey.toByteArray())
        return b.substring(30)
    }

}