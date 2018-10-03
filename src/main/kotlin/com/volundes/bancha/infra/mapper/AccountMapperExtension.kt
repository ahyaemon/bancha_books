package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.obj.account.Account
import com.volundes.bancha.domain.obj.general.profile.Hitokoto
import com.volundes.bancha.domain.obj.general.profile.Profile
import com.volundes.bancha.infra.entity.ProfileEntity
import com.volundes.bancha.infra.entity.table.AccountTable

interface AccountMapperExtension {

    fun AccountTable.toAccount() = Account(id, email, pass, role, nickname)

    fun Account.toTable(): AccountTable {
        val table = AccountTable()
        table.id = id
        table.email = email
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