package com.volundes.bancha.domain.subtitle

import com.volundes.bancha.infra.repository.SubtitleRepository
import org.springframework.stereotype.Component
import java.lang.Math.abs
import java.util.*

@Component
class SubtitleProvider(
        private val repository: SubtitleRepository
) {

    fun get(titleCd: String): String {
        val subtitles = repository.selectByTitleCd(titleCd)
        val rand = abs(Random().nextInt()) % subtitles.size
        return subtitles[rand].subtitle
    }

}