package com.volundes.bancha.web.donation

import com.volundes.bancha.domain.`object`.donation.Donation

data class DonationItem(
        val donationId: Long?,
        val name: String,
        val comment: String,
        val amount: String
){
    constructor(donation: Donation): this(donation.id, donation.name, donation.comment, donation.amount.toString())
}