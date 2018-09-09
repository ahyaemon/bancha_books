package com.volundes.bancha.web.general.register

import com.volundes.bancha.domain.account.Account

data class AccountCreateForm(
    val mailAddress: String,
    val password: String,
    val password2: String,
    val nickname: String,
    val hitokoto: String
) {

    fun toAccount(): Account {
        return Account(
                null,
                mailAddress,
                password,
                "GENERAL",
                nickname
        )
    }

}