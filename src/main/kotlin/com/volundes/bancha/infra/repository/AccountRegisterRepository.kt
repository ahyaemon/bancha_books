package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.general.login.AccountRegister
import com.volundes.bancha.infra.dao.AccountRegisterDao
import com.volundes.bancha.infra.mapper.AccountRegisterMapperExtension
import org.springframework.stereotype.Repository

@Repository
class AccountRegisterRepository(
        private val accountRegisterDao: AccountRegisterDao
):
        AccountRegisterMapperExtension
{

    fun addAccountRegister(accountRegister: AccountRegister){
        val table = accountRegister.toTable()
        accountRegisterDao.insert(table)
    }

}