package com.volundes.bancha.domain.service.general.profile

import com.volundes.bancha.domain.obj.general.profile.Hitokoto
import com.volundes.bancha.domain.obj.general.profile.Profile
import com.volundes.bancha.infra.repository.ProfileRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
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