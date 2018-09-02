package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.general.profile.Hitokoto
import com.volundes.bancha.domain.general.profile.Profile
import com.volundes.bancha.infra.dao.AccountDao
import com.volundes.bancha.infra.dao.HitokotoDao
import com.volundes.bancha.infra.mapper.AccountMapperExtension
import com.volundes.bancha.infra.mapper.HitokotoMapperExtension
import org.springframework.stereotype.Repository

@Repository
class ProfileRepository(
        private val hitokotoDao: HitokotoDao,
        private val accountDao: AccountDao
):
        HitokotoMapperExtension,
        AccountMapperExtension
{

    fun findHitokoto(accountId: Long): Hitokoto? {
        return hitokotoDao.selectByAccountId(accountId).toHitokoto()
    }

    fun editProfile(profile: Profile) {
        if(profile.account.accountId == null){
            return
        }

        val account = profile.account
        val table = account.toTable()
        accountDao.update(table)

        val hitokoto = profile.hitokoto
        if(hitokoto != null){
            val table = hitokoto.toTable(profile.account.accountId)

            if(hitokoto.hitokotoId == null){
                hitokotoDao.insert(table)
            }
            else{
                if(hitokoto.value == ""){
                    hitokotoDao.delete(table)
                }
                else{
                    hitokotoDao.update(table)
                }
            }
        }

    }

    fun findProfile(accountId: Long) :Profile {
        val profileEntity = accountDao.selectProfileByAccountId(accountId)
        return profileEntity.toProfile()
    }

}
