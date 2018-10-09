package com.volundes.bancha.infra.repository

import com.volundes.bancha.infra.dao.SubtitleDao
import com.volundes.bancha.infra.mapper.SubtitleMapperExtension
import org.springframework.stereotype.Repository

@Repository
class SubtitleRepository(
        private val dao: SubtitleDao
):
        SubtitleMapperExtension
{

    private val subtitles  by lazy { dao.select().toSubtitles() }

    fun findByTitleCd(titleCd: String) = subtitles.filter{ it.titleCd == titleCd }

}