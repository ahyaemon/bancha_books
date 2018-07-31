package com.volundes.bancha.web.controller.donation

import com.volundes.bancha.domain.dto.Donation
import javax.validation.constraints.Min
import javax.validation.constraints.Pattern

data class DonationItem(
        val donationId: Long?,
        val name: String,
        val comment: String,
        val amount: String
){
    constructor(donation: Donation): this(donation.donationId, donation.name, donation.comment, donation.amount.toString())
}