package com.volundes.bancha.infra.repository

import com.volundes.bancha.infra.dao.AccountDao
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

}