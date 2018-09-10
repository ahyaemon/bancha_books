package com.volundes.bancha.web.donation

import com.volundes.bancha.domain.donation.Donation
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

data class TestPayForm(
        @get:NotBlank(message="{TestPayForm.email.NotBlank}")
        val name: String,

        val comment: String = "",

        @get:Min(value = 1000, message = "{TestPayForm.amount.Min}")
        @get:Pattern(regexp = "\\d+", message="{TestPayForm.amount.Patter}")
        val amount: String = "0"
){

    fun toDonation() = Donation(null, name, comment, amount.toLong())

}