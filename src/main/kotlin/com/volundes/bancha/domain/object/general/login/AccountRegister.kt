package com.volundes.bancha.domain.`object`.general.login

import java.time.LocalDateTime

data class AccountRegister(
        val id: Long?,
        val email: String,
        val urlKey: String,
        val createDateTime: LocalDateTime

)