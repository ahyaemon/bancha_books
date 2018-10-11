package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.obj.donation.Donation
import com.volundes.bancha.infra.dao.DonationDao
import com.volundes.bancha.infra.mapper.DonationMapperExtension
import org.springframework.stereotype.Repository

@Repository
class DonationRepository(
        private val donationDao: DonationDao
):
        DonationMapperExtension
{

    fun add(donation: Donation){
        donationDao.insert(donation.toEntity())
    }

    fun sum(): Long{
        val entity = donationDao.sum()
        return when(entity.amount == null){
            true -> 0
            false -> entity.amount
        }
    }

    fun find() = donationDao.select().toDonations()

}