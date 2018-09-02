package com.volundes.bancha.web.general.profile

import com.volundes.bancha.domain.account.Account
import com.volundes.bancha.domain.general.profile.Hitokoto

data class ProfileEditForm(
        val nickname: String,
        val mailAddress: String,
        val hitokoto: String
){

    constructor(
            account: Account,
            hitokoto: Hitokoto?

    ): this (
            account.nickname,
            account.name,
            if(hitokoto == null){
                ""
            }else{
                hitokoto.value
            }
    )

}