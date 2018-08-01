package com.volundes.bancha.web.donation

import com.volundes.bancha.domain.donation.Donation
import javax.validation.constraints.Min
import javax.validation.constraints.Pattern

data class TestPayForm(
        var name: String = "名無しのGonbey",
        var comment: String = "",
        @get:Min(value = 1000, message = "※ 1000円以下の寄付は受け付けておりません")
        @get:Pattern(regexp = "\\d+", message="それっていくら？")
        var amount: String = "0"
){

    fun toDonation() = Donation(null, name, comment, amount.toLong())

}