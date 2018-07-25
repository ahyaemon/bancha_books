package com.volundes.bancha.domain.service

import com.volundes.bancha.domain.dto.Book
import com.volundes.bancha.domain.dto.Donation
import com.volundes.bancha.domain.repository.BookRepository
import com.volundes.bancha.domain.repository.DonationRepository
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