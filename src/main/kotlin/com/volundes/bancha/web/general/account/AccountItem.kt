package com.volundes.bancha.web.general.account

import com.volundes.bancha.domain.obj.account.Account

data class AccountItem(
        val name: String,
        val hitokoto: String
) {

    constructor(
            account: Account
    ): this (
            account.name,
            if(account.hitokoto == null){
                ""
            }
            else{
                account.hitokoto.value
            }
    )

}