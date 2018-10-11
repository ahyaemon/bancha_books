package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.obj.donation.Donation
import com.volundes.bancha.infra.entity.table.DonationTable

interface DonationMapperExtension {

    fun Donation.toEntity() = DonationTable(id, name, comment, amount)
    fun DonationTable.toDonation() = Donation(id, name, comment, amount)
    fun List<DonationTable>.toDonations() = map{ it.toDonation() }

}