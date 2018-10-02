package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.`object`.donation.Donation
import com.volundes.bancha.infra.entity.table.DonationTable

interface DonationMapperExtension {

    fun Donation.toEntity(): DonationTable {
        val entity = DonationTable()
        entity.name = name
        entity.comment = comment
        entity.amount = amount
        return entity
    }

    fun DonationTable.toDonation() = Donation(id, name, comment, amount)
    fun List<DonationTable>.toDonations() = map{ it.toDonation() }

}