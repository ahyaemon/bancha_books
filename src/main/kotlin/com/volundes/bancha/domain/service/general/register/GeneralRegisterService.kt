package com.volundes.bancha.domain.service.general.register

import com.volundes.bancha.domain.obj.account.Account
import com.volundes.bancha.domain.obj.general.profile.Hitokoto
import com.volundes.bancha.infra.repository.AccountRegisterRepository
import com.volundes.bancha.infra.repository.AccountRepository
import com.volundes.bancha.infra.repository.ProfileRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class GeneralRegisterService(
        private val accountRegisterRepository: AccountRegisterRepository,
        private val accountRepository: AccountRepository,
        private val profileRepository: ProfileRepository,
        private val passwordEncoder: PasswordEncoder
) {

    fun existsUrlKey(urlKey: String): Boolean {
        return accountRegisterRepository.existsUrlKey(urlKey)
    }

    fun getMailAddress(urlKey: String): String {
        return accountRegisterRepository.findEmail(urlKey)
    }

    fun addAccount(account: Account) {
        val passwordEncryptedAccount =
                account.copy(pass = passwordEncoder.encode(account.pass))
        accountRepository.addAccount(passwordEncryptedAccount)
    }

    fun getAccountId(account: Account): Long {
        return accountRepository.getAccountId(account)
    }

    fun addHitokoto(accountId: Long, hitokoto: Hitokoto) {
        profileRepository.addHitokoto(accountId, hitokoto)
    }

}