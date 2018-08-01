package com.volundes.bancha.domain.repository

import com.volundes.bancha.domain.dto.Donation
import com.volundes.bancha.infra.dao.DonationDao
import com.volundes.bancha.infra.mapper.DonationInfraMapper
import org.springframework.stereotype.Repository

@Repository
class DonationRepository(
        private val mapper: DonationInfraMapper,
        private val donationDao: DonationDao
) {

    fun add(donation: Donation){
        donationDao.insert(mapper.toEntity(donation))
    }

    fun sum(): Long{
        val entity = donationDao.sum()
        when(entity.amount == null){
            true -> return 0
            false -> return entity.amount
        }
    }

    fun get() = mapper.toDonation(donationDao.select())

}