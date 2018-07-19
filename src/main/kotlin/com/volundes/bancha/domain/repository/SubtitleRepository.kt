package com.volundes.bancha.domain.repository

import com.volundes.bancha.domain.dto.Subtitle

class SubtitleRepository(
    private val subtitles: List<Subtitle>
) {

    fun selectByTitleCd(titleCd: String): List<Subtitle>{
        return subtitles.filter{ it.titleCd == titleCd }
    }

}