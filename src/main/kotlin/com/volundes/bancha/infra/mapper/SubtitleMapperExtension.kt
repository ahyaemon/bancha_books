package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.subtitle.Subtitle
import com.volundes.bancha.infra.entity.table.SubtitleTable
import org.springframework.stereotype.Component

interface SubtitleMapperExtension {

    fun SubtitleTable.toSubtitle() = Subtitle(subtitleId, titleCd, subtitle)
    fun List<SubtitleTable>.toSubtitles() = map{ it.toSubtitle() }

}