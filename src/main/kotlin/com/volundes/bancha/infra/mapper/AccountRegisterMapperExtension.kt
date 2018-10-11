package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.obj.general.login.AccountRegister
import com.volundes.bancha.infra.entity.table.AccountRegisterTable

interface AccountRegisterMapperExtension {

    fun AccountRegister.toTable() =  AccountRegisterTable(id, email, urlKey, createDateTime)

}