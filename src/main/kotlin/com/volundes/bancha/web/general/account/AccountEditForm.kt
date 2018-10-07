package com.volundes.bancha.web.general.account

import com.volundes.bancha.domain.obj.account.Account

data class AccountEditForm(
        val name: String,
        val email: String,
        val hitokotoId: Long?,
        val hitokotoValue: String?
){

    constructor(
            account: Account
    ): this(
            account.name,
            account.authInfo.email,
            if(account.hitokoto == null) {
                null
            } else {
                account.hitokoto.id
            },
            if(account.hitokoto == null) {
                null
            } else {
                account.hitokoto.value
            }
    )

    fun toAccount(account: Account): Account {
        val newAuthInfo = account.authInfo.copy(email = email)
        val newHitokoto =
        if(account.hitokoto == null) {
            null
        } else {
            account.hitokoto.copy(
                    value = hitokotoValue ?: ""
            )
        }
        return account.copy(
                name = name,
                authInfo = newAuthInfo,
                hitokoto = newHitokoto
        )
    }

}