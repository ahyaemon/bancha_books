package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.general.profile.Hitokoto
import com.volundes.bancha.domain.general.profile.Profile
import com.volundes.bancha.infra.entity.table.HitokotoTable

interface HitokotoMapperExtension {

    fun HitokotoTable?.toHitokoto(): Hitokoto? {
        return if(this == null){
            null
        }else{
            Hitokoto(hitokotoId, value)
        }
    }

    fun Hitokoto.toTable(accountId: Long): HitokotoTable {
        val table = HitokotoTable()
        table.hitokotoId = hitokotoId
        table.accountId = accountId
        table.value = value
        return table
    }

}