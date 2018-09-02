package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.general.profile.Hitokoto
import com.volundes.bancha.infra.dao.HitokotoDao
import com.volundes.bancha.infra.mapper.HitokotoMapperExtension
import org.springframework.stereotype.Repository

@Repository
class ProfileRepository(
        private val hitokotoDao: HitokotoDao
):
        HitokotoMapperExtension
{

    fun findHitokoto(accountId: Long): Hitokoto? {
        return hitokotoDao.selectByAccountId(accountId).toHitokoto()
    }

}
