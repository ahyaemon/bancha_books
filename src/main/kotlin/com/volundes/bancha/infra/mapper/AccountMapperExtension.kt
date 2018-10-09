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

    fun AuthInfoTable.toAuthInfo() = AuthInfo(id, email, password, role)
    fun AuthInfo.toTable(accountId: Long) = AuthInfoTable(id, accountId.toInt(), email, password, role)
    fun Account.toTable() = AccountTable(id, name)
    fun Hitokoto.toTable(accountId: Long) = HitokotoTable(id, accountId.toInt(), value)

}