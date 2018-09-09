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

    /**
     * 新規発行されたURLをDBに登録します。
     */
    fun addAccountRegister(accountRegister: AccountRegister){
        val table = accountRegister.toTable()
        accountRegisterDao.insert(table)
    }

    /**
     * urlKeyがDBに存在するかどうか確認します。
     * 存在する場合、trueを返します。
     */
    fun existsUrlKey(urlKey: String): Boolean {
        val count = accountRegisterDao.countUrlKey(urlKey)
        return count >= 1
    }

    fun findMailAddress(urlKey: String): String {
        val mailAddress = accountRegisterDao.selectMailAddressByUrlKey(urlKey)
        return mailAddress
    }

}