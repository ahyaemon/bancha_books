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
        entity.amount = donation.amount
        return entity
    }

}