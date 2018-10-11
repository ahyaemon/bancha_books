package com.volundes.bancha.domain.service.admin.maintenance.subtitle

import com.volundes.bancha.domain.obj.subtitle.Subtitle
import com.volundes.bancha.infra.repository.SubtitleRepository
import org.springframework.stereotype.Service

@Service
class SubtitleMaintenanceService(
        private val subtitleRepository: SubtitleRepository
) {

    fun getSubtitles(): List<Subtitle> {
        return subtitleRepository.find()
    }

}