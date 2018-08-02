package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.account.Account
import com.volundes.bancha.infra.entity.AccountEntity
import org.springframework.stereotype.Component

@Component
class AccountInfraMapper {

    fun toAccount(entity: AccountEntity): Account {
        return Account(entity.accountId, entity.name, entity.pass, entity.role)
    }

}