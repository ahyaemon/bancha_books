package com.volundes.bancha.domain.general.profile

import com.volundes.bancha.domain.account.Account

data class Profile(
        val account: Account,
        val hitokoto: Hitokoto?
)