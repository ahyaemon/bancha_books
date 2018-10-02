package com.volundes.bancha.web.general.register

import com.volundes.bancha.domain.`object`.account.Account

data class AccountCreateForm(
        val email: String,
        val password: String,
        val password2: String,
        val nickname: String,
        val hitokoto: String
) {

    fun toAccount(): Account {
        return Account(
                null,
                email,
                password,
                "GENERAL",
                nickname
        )
    }

}