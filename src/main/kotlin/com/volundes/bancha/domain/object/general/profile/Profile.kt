package com.volundes.bancha.domain.`object`.general.profile

import com.volundes.bancha.domain.`object`.account.Account

data class Profile(
        val account: Account,
        val hitokoto: Hitokoto?
)