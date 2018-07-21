package com.volundes.bancha.domain.dto

data class Account(
    val accountId: Long?,
    val name: String,
    val pass: String,
    val role: String
)