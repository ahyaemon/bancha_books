package com.volundes.bancha.web.general.profile

import com.volundes.bancha.domain.obj.account.Account
import com.volundes.bancha.domain.obj.general.profile.Hitokoto
import com.volundes.bancha.domain.obj.general.profile.Profile

data class ProfileEditForm(
        val nickname: String,
        val email: String,
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
            hitokoto.id,
            hitokoto.value
    )

    fun toProfile(
            account: Account
    ): Profile {
        val copiedAccount = account.copy(
                nickname = nickname,
                email = email
        )
        val hitokoto = Hitokoto(
                hitokotoId,
                hitokoto ?: ""
        )
        return Profile(copiedAccount, hitokoto)
    }

}