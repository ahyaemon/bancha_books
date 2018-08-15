package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.subtitle.Subtitle
import com.volundes.bancha.infra.entity.table.SubtitleTable
import org.springframework.stereotype.Component

@Component
class SubtitleInfraMapper {

    fun toSubtitle(entities: List<SubtitleTable>): List<Subtitle> {
        return entities.map{ Subtitle(it.subtitleId, it.titleCd, it.subtitle) }
    }

}