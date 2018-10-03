package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.obj.general.profile.Hitokoto
import com.volundes.bancha.domain.obj.general.profile.Profile
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
        if(profile.account.id == null){
            return
        }

        val account = profile.account
        val accountTable = account.toTable()
        accountDao.update(accountTable)

        val hitokoto = profile.hitokoto
        if(hitokoto != null){
            val hitokotoTable = hitokoto.toTable(profile.account.id)

            if(hitokoto.id == null){
                hitokotoDao.insert(hitokotoTable)
            }
            else{
                if(hitokoto.value == ""){
                    hitokotoDao.delete(hitokotoTable)
                }
                else{
                    hitokotoDao.update(hitokotoTable)
                }
            }
        }

    }

    fun findProfile(accountId: Long) : Profile {
        val profileEntity = accountDao.selectProfileByAccountId(accountId)
        return profileEntity.toProfile()
    }

    fun addHitokoto(accountId: Long, hitokoto: Hitokoto) {
        val table = hitokoto.toTable(accountId)
        hitokotoDao.insert(table)
    }

}
