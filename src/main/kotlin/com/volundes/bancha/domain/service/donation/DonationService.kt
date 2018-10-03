package com.volundes.bancha.domain.service.donation

import com.volundes.bancha.domain.obj.donation.Donation
import com.volundes.bancha.infra.repository.DonationRepository
import org.springframework.stereotype.Service

/**
 * 寄付を管理するServiceです。
 */
@Service
class DonationService(
        private val repository: DonationRepository
) {

    /**
     * 新しい寄付を登録します。
     */
    fun add(donation: Donation){
        return repository.add(donation)
    }

    /**
     * @return 今までの寄付の合計金額
     */
    fun sum(): Long{
        return repository.sum()
    }

    /**
     * @return 今までの寄付の情報のリスト
     */
    fun getDonations(): List<Donation> {
        return repository.get()
    }

}