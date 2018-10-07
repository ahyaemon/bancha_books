package com.volundes.bancha.domain.obj.account

data class AuthInfo(
        val id: Long?,
        val email: String,
        val password: String,
        val role: String
)