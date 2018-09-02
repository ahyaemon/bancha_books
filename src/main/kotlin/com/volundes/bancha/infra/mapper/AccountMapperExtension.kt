package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.account.Account
import com.volundes.bancha.domain.general.profile.Hitokoto
import com.volundes.bancha.domain.general.profile.Profile
import com.volundes.bancha.infra.entity.ProfileEntity
import com.volundes.bancha.infra.entity.table.AccountTable

interface AccountMapperExtension {

    fun AccountTable.toAccount() =  Account(accountId, name, pass, role, nickname)

    fun Account.toTable(): AccountTable {
        val table = AccountTable()
        table.accountId = accountId
        table.name = name
        table.pass = pass
        table.role = role
        table.nickname = nickname

        return table
    }

    fun ProfileEntity.toProfile(): Profile {
        val account = Account(
                accountId,
                name,
                pass,
                role,
                nickname
        )
        val hitokoto = Hitokoto(
                hitokotoId,
                hitokotoValue
        )
        return Profile(account, hitokoto)
    }

}