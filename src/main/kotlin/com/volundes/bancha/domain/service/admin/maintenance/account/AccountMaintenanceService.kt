package com.volundes.bancha.domain.service.admin.maintenance.account

import com.volundes.bancha.domain.obj.account.Account
import com.volundes.bancha.infra.repository.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AccountMaintenanceService(
        private val accountRepository: AccountRepository
) {

    fun getAccounts(): List<Account> {
        return accountRepository.find()
    }

}