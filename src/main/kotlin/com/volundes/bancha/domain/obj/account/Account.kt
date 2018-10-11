package com.volundes.bancha.domain.obj.account

data class Account(
        val id: Long?,
        val name: String,
        val authInfo: AuthInfo,
        val hitokoto: Hitokoto?
)