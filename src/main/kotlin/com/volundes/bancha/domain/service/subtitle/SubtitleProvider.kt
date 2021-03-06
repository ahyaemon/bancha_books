package com.volundes.bancha.domain.service.subtitle

import com.volundes.bancha.infra.repository.SubtitleRepository
import org.springframework.stereotype.Component
import java.lang.Math.abs
import java.util.*

/**
 * サブタイトルを取得するためのProviderです。
 */
@Component
class SubtitleProvider(
        private val repository: SubtitleRepository
) {

    /**
     * titleCdに対応するsubtitleの中から、ランダムで一つ抜き出して返します。
     *
     * @return サブタイトル
     */
    fun get(titleCd: String): String {
        val subtitles = repository.findByTitleCd(titleCd)
        val rand = abs(Random().nextInt()) % subtitles.size
        return subtitles[rand].value
    }

}