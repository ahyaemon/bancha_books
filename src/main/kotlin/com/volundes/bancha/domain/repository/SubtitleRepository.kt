package com.volundes.bancha.domain.repository

import com.volundes.bancha.domain.dto.Subtitle
import com.volundes.bancha.infra.dao.SubtitleDao
import com.volundes.bancha.infra.mapper.SubtitleInfraMapper
import org.springframework.stereotype.Repository

@Repository
class SubtitleRepository(
        private val dao: SubtitleDao,
        private val mapper: SubtitleInfraMapper
) {

    private val subtitles = mapper.toSubtitle( dao.select())

    fun selectByTitleCd(titleCd: String): List<Subtitle>{
        return subtitles.filter{ it.titleCd == titleCd }
    }

}