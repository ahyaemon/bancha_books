package com.volundes.bancha.domain.service.general.register

import com.volundes.bancha.domain.obj.account.Account
import com.volundes.bancha.infra.repository.AccountRegisterRepository
import com.volundes.bancha.infra.repository.AccountRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class GeneralRegisterService(
        private val accountRegisterRepository: AccountRegisterRepository,
        private val accountRepository: AccountRepository,
        private val passwordEncoder: PasswordEncoder
) {

    fun existsUrlKey(urlKey: String): Boolean {
        return accountRegisterRepository.existsUrlKey(urlKey)
    }

    fun getMailAddress(urlKey: String): String {
        return accountRegisterRepository.findEmail(urlKey)
    }

    fun addAccount(account: Account) {
        val encryptedPassword = passwordEncoder.encode(account.authInfo.password)
        val passwordEncryptedAccount = account.copy(
                authInfo = account.authInfo.copy(
                        password = encryptedPassword
                )
        )
        accountRepository.addAccount(passwordEncryptedAccount)
    }

}