package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.general.profile.Hitokoto
import com.volundes.bancha.infra.entity.table.HitokotoTable

interface HitokotoMapperExtension {

    fun HitokotoTable?.toHitokoto(): Hitokoto? {
        return if(this == null){
            null
        }else{
            Hitokoto(accountId, hitokotoId, value)
        }
    }

}