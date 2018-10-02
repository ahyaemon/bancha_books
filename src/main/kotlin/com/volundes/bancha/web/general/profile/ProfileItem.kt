package com.volundes.bancha.web.general.profile

import com.volundes.bancha.domain.`object`.general.profile.Profile

data class ProfileItem(
        val nickname: String,
        val hitokoto: String
) {

    constructor(
            profile: Profile
    ): this (
            profile.account.nickname,
            if(profile.hitokoto == null){
                ""
            }
            else{
                profile.hitokoto.value
            }
    )

}