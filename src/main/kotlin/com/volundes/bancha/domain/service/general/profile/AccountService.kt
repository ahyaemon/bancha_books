package com.volundes.bancha.domain.service.general.profile

import com.volundes.bancha.domain.obj.account.Account
import com.volundes.bancha.infra.repository.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AccountService(
        private val accountRepository: AccountRepository
) {

    fun getAccount(accountId: Long): Account {
        return accountRepository.findById(accountId)
    }

    fun editAccount(account: Account) {
        accountRepository.update(account)
    }

}