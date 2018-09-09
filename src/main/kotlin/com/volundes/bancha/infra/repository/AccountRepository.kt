package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.account.Account
import com.volundes.bancha.domain.general.profile.Hitokoto
import com.volundes.bancha.infra.dao.AccountDao
import com.volundes.bancha.infra.entity.table.HitokotoTable
import com.volundes.bancha.infra.mapper.AccountMapperExtension
import org.springframework.stereotype.Repository

@Repository
class AccountRepository(
        private val accountDao: AccountDao
):
        AccountMapperExtension
{

    fun getByUsername(name: String) =
            accountDao.selectByName(name).toAccount()

    fun addAccount(account: Account) {
        accountDao.insert(account.toTable())
    }

    fun getAccountId(account: Account): Long {
        val table = accountDao.selectByName(account.name)
        return table.accountId
    }

}