package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.`object`.general.profile.Hitokoto
import com.volundes.bancha.infra.entity.table.HitokotoTable

interface HitokotoMapperExtension {

    fun HitokotoTable?.toHitokoto(): Hitokoto? {
        return if(this == null){
            null
        }else{
            Hitokoto(id, value)
        }
    }

    fun Hitokoto.toTable(accountId: Long): HitokotoTable {
        val table = HitokotoTable()
        table.id = id
        table.accountId = accountId
        table.value = value
        return table
    }

}