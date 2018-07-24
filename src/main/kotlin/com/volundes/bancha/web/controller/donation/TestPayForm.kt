package com.volundes.bancha.web.controller.donation

import com.volundes.bancha.domain.dto.Donation
import javax.validation.constraints.Min
import javax.validation.constraints.Pattern

/**
 * amountだけだと空のときにフォーム自体がnullで送られてくるため、
 * とりあえずtypeをつけておく
 */
data class TestPayForm(
        @get:Min(value = 1000, message = "※ 1000円以下の寄付は受け付けておりません")
        @get:Pattern(regexp = "\\d+", message="それっていくら？")
        var amount: String = "0",

        var type: String = "TEST"
){

    fun toDonation(): Donation{
        if(amount == null){
            return Donation(0)
        }
        return Donation(amount.toLong())
    }

}