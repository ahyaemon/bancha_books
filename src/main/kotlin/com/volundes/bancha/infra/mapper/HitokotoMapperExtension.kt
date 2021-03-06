package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.obj.account.Hitokoto
import com.volundes.bancha.infra.entity.table.HitokotoTable

interface HitokotoMapperExtension {

    fun HitokotoTable?.toHitokoto(): Hitokoto? {
        return if(this == null){
            null
        }else{
            Hitokoto(id, value)
        }
    }

    fun Hitokoto.toTable(accountId: Long) = HitokotoTable(id, accountId.toInt(), value)

}