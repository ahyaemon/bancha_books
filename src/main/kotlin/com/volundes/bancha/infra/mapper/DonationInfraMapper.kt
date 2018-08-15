package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.donation.Donation
import com.volundes.bancha.infra.entity.table.DonationTable
import org.springframework.stereotype.Component

@Component
class DonationInfraMapper {

    fun toEntity(donation: Donation): DonationTable {
        val entity = DonationTable()
        entity.name = donation.name
        entity.comment = donation.comment
        entity.amount = donation.amount
        return entity
    }

    fun toDonation(entities: List<DonationTable>): List<Donation> {
        return entities.map{ Donation(it.donationId, it.name, it.comment, it.amount) }
    }

}