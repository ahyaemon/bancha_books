package com.volundes.bancha.domain.`object`.general.login

import java.time.LocalDateTime

data class AccountRegister(
        val accountRegisterId: Long?,
        val email: String,
        val urlKey: String,
        val createDateTime: LocalDateTime

)