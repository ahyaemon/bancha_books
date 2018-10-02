package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.general.login.AccountRegister
import com.volundes.bancha.infra.entity.table.AccountRegisterTable

interface AccountRegisterMapperExtension {

    fun AccountRegister.toTable(): AccountRegisterTable {
        val table = AccountRegisterTable()
        table.id = accountRegisterId
        table.email = email
        table.urlKey = urlKey
        table.createDateTime = createDateTime
        return table
    }

}