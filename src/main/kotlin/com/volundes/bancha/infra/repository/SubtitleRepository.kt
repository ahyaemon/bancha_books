package com.volundes.bancha.infra.repository

import com.volundes.bancha.infra.dao.SubtitleDao
import com.volundes.bancha.infra.mapper.SubtitleInfraMapper
import org.springframework.stereotype.Repository

@Repository
class SubtitleRepository(
        private val dao: SubtitleDao,
        private val mapper: SubtitleInfraMapper
) {

    private val subtitles  by lazy { mapper.toSubtitle( dao.select()) }

    fun selectByTitleCd(titleCd: String) = subtitles.filter{ it.titleCd == titleCd }

}