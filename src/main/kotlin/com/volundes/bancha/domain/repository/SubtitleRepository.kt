package com.volundes.bancha.domain.repository

import com.volundes.bancha.infra.dao.PersonDao
import com.volundes.bancha.infra.entity.PersonEntity
import com.volundes.bancha.domain.dto.Person
import com.volundes.bancha.domain.dto.Subtitle
import com.volundes.bancha.infra.dao.SubtitleDao
import com.volundes.bancha.infra.entity.SubtitleEntity
import com.volundes.bancha.infra.mapper.PersonInfraMapper
import com.volundes.bancha.infra.mapper.SubtitleInfraMapper
import org.springframework.stereotype.Repository

@Repository
class SubtitleRepository(
        private val dao: SubtitleDao,
        private val mapper: SubtitleInfraMapper
) {

    fun selectByTitleCd(titleCd: String): List<Subtitle>{
        val entities = dao.selectByTitleCd(titleCd)
        return mapper.toSubtitle(entities)
    }

}