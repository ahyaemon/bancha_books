package com.volundes.bancha.domain.account

data class Account(
    val accountId: Long?,
    val name: String,
    val pass: String,
    val role: String,
    val nickname: String
)