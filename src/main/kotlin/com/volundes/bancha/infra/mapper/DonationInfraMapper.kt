package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.dto.Donation
import com.volundes.bancha.domain.dto.Subtitle
import com.volundes.bancha.infra.entity.DonationEntity
import com.volundes.bancha.infra.entity.SubtitleEntity
import org.springframework.stereotype.Component

@Component
class DonationInfraMapper {

    fun toEntity(donation: Donation): DonationEntity{
        val entity = DonationEntity()
        entity.name = donation.name
        entity.comment = donation.comment
        entity.amount = donation.amount
        return entity
    }

    fun toDonation(entities: List<DonationEntity>): List<Donation> {
        return entities.map{ Donation(it.donationId, it.name, it.comment, it.amount) }
    }

}