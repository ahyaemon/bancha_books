package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.obj.account.Account
import com.volundes.bancha.domain.obj.account.AuthInfo
import com.volundes.bancha.domain.obj.account.Hitokoto
import com.volundes.bancha.infra.entity.AccountEntity
import com.volundes.bancha.infra.entity.table.AccountTable
import com.volundes.bancha.infra.entity.table.AuthInfoTable
import com.volundes.bancha.infra.entity.table.HitokotoTable

interface AccountMapperExtension {

    fun AccountEntity.toAccount(): Account {
        val authInfo = AuthInfo(authInfoId, email, password, role)
        val hitokoto = if(hitokotoId == null) {
            null
        } else {
            Hitokoto(hitokotoId, hitokotoValue)
        }
        return Account(accountId, name, authInfo, hitokoto)
    }

    fun AuthInfoTable.toAuthInfo(): AuthInfo {
        return AuthInfo(id, email, password, role)
    }

    fun AuthInfo.toTable(accountId: Long): AuthInfoTable {
        val table = AuthInfoTable()
        table.id = id
        table.accountId = accountId
        table.email = email
        table.password = password
        table.role = role
        return table
    }

    fun Account.toTable(): AccountTable {
        val table = AccountTable()
        table.id = id
        table.name = name
        return table
    }

    fun Hitokoto.toTable(accountId: Long): HitokotoTable {
        val table = HitokotoTable()
        table.id = id
        table.accountId = accountId
        table.value = value
        return table
    }

}