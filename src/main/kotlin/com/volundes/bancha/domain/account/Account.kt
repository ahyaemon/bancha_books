package com.volundes.bancha.domain.account

data class Account(
        val accountId: Long?,
        val email: String,
        val pass: String,
        val role: String,
        val nickname: String
)