package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.obj.subtitle.Subtitle
import com.volundes.bancha.infra.entity.table.SubtitleTable

interface SubtitleMapperExtension {

    fun SubtitleTable.toSubtitle() = Subtitle(id, titleCd, value)
    fun List<SubtitleTable>.toSubtitles() = map{ it.toSubtitle() }

}