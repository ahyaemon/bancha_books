package com.volundes.bancha.web.general.register

import com.volundes.bancha.domain.obj.account.Account
import com.volundes.bancha.domain.obj.account.AuthInfo
import com.volundes.bancha.domain.obj.account.Hitokoto

data class AccountCreateForm(
        val email: String,
        val password: String,
        val password2: String,
        val name: String,
        val hitokotoValue: String
) {

    fun toAccount(): Account {
        val authInfo = AuthInfo(null, email, password, "GENERAL")
        val hitokoto = if(hitokotoValue == "") {
            null
        }
        else {
            Hitokoto(null, hitokotoValue)
        }

        return Account(
                null,
                name,
                authInfo,
                hitokoto
        )
    }

}