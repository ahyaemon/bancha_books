package com.volundes.bancha.domain.donation

import com.volundes.bancha.infra.repository.DonationRepository
import org.springframework.stereotype.Service

@Service
class DonationService(
        private val repository: DonationRepository
) {

    fun add(donation: Donation){
        return repository.add(donation)
    }

    fun sum(): Long{
        return repository.sum()
    }

    fun getDonations(): List<Donation> {
        return repository.get()
    }

}