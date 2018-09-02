package com.volundes.bancha.domain.general.profile

import com.volundes.bancha.infra.repository.ProfileRepository
import org.springframework.stereotype.Service

@Service
class ProfileService(
        private val profileRepository: ProfileRepository
) {

    fun getHitokoto(accountId: Long): Hitokoto? {
        return profileRepository.findHitokoto(accountId)
    }

    fun editProfile(profile: Profile) {
        profileRepository.editProfile(profile)
    }

    fun getProfile(accountId: Long): Profile {
        return profileRepository.findProfile(accountId)
    }

}