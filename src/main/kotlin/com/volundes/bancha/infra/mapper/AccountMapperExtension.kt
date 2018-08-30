package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.account.Account
import com.volundes.bancha.infra.entity.table.AccountTable

interface AccountMapperExtension {

    fun AccountTable.toAccount() =  Account(accountId, name, pass, role, nickname)

}