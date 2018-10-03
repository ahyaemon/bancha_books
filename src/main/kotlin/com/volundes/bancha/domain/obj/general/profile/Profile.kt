package com.volundes.bancha.domain.obj.general.profile

import com.volundes.bancha.domain.obj.account.Account

data class Profile(
        val account: Account,
        val hitokoto: Hitokoto?
)