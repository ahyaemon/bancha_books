package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.subtitle.Subtitle
import com.volundes.bancha.infra.entity.SubtitleEntity
import org.springframework.stereotype.Component

@Component
class SubtitleInfraMapper {

    fun toSubtitle(entities: List<SubtitleEntity>): List<Subtitle> {
        return entities.map{ Subtitle(it.subtitleId, it.titleCd, it.subtitle) }
    }

}