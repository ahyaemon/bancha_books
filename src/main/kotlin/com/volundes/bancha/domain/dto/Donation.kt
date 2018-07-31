package com.volundes.bancha.domain.dto

data class Donation (
        val donationId: Long?,
        val name: String,
        val comment: String,
        val amount: Long
)