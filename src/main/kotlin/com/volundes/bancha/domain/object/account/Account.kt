package com.volundes.bancha.domain.`object`.account

// FIXME ドメインモデル的には Account が Hitokoto を持っている
data class Account(
        val accountId: Long?,
        val email: String,
        val pass: String,
        val role: String,
        val nickname: String
)