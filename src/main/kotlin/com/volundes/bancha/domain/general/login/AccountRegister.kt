package com.volundes.bancha.domain.general.login

import java.time.LocalDateTime

data class AccountRegister(
        val accountRegisterId: Long?,
        val mailAddress: String,
        val urlKey: String,
        val createDateTime: LocalDateTime

)