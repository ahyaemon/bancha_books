package com.volundes.bancha.web.general.profile

import com.volundes.bancha.domain.account.Account
import com.volundes.bancha.domain.general.profile.Hitokoto
import com.volundes.bancha.domain.general.profile.Profile

data class ProfileEditForm(
        val nickname: String,
        val mailAddress: String,
        val hitokotoId: Long?,
        val hitokoto: String?
){

    constructor(
            account: Account
    ): this(
            account.nickname,
            account.email,
            null,
            null
    )

    constructor(
            account: Account,
            hitokoto: Hitokoto
    ): this (
            account.nickname,
            account.email,
            hitokoto.hitokotoId,
            hitokoto.value
    )

    fun toProfile(
            account: Account
    ): Profile {
        val copiedAccount = account.copy(
                nickname = nickname,
                email = mailAddress
        )
        val hitokoto = Hitokoto(
                hitokotoId,
                hitokoto ?: ""
        )
        return Profile(copiedAccount, hitokoto)
    }

}