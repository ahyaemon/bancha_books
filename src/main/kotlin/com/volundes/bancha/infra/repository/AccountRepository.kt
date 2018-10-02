package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.account.Account
import com.volundes.bancha.infra.dao.AccountDao
import com.volundes.bancha.infra.mapper.AccountMapperExtension
import org.springframework.stereotype.Repository

@Repository
class AccountRepository(
        private val accountDao: AccountDao
):
        AccountMapperExtension
{

    fun findByEmail(email: String) =
            accountDao.selectByEmail(email).toAccount()

    fun addAccount(account: Account) {
        accountDao.insert(account.toTable())
    }

    fun getAccountId(account: Account): Long {
        val table = accountDao.selectByEmail(account.email)
        return table.id
    }

}