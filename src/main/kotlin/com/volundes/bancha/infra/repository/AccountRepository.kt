package com.volundes.bancha.infra.repository

import com.volundes.bancha.infra.dao.AccountDao
import com.volundes.bancha.infra.mapper.AccountInfraMapper
import org.springframework.stereotype.Repository

@Repository
class AccountRepository(
        private val accountDao: AccountDao,
        private val accountInfraMapper: AccountInfraMapper
        ) {

    fun getByUsername(name: String) =
            accountInfraMapper.toAccount(accountDao.selectByName(name))

}