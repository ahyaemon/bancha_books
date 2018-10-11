package com.volundes.bancha.web.admin.maintenance.account

import com.volundes.bancha.domain.obj.account.Account

data class AccountMaintenanceItem(
        val accountId: String,
        val name: String,
        val authInfoId: String,
        val email: String,
        val password: String,
        val role: String,
        val hitokotoId: String,
        val hitokotoValue: String
) {

    constructor(account: Account): this(
            account.id.toString(),
            account.name,
            account.authInfo.id.toString(),
            account.authInfo.email,
            account.authInfo.password,
            account.authInfo.role,
            if(account.hitokoto == null) { "" } else { account.hitokoto.id.toString() },
            if(account.hitokoto == null) { "" } else { account.hitokoto.value}
    )

}