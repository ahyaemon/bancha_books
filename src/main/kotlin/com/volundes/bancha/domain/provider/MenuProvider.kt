package com.volundes.bancha.domain.provider

import com.volundes.bancha.domain.dto.Menu
import com.volundes.bancha.domain.repository.MenuRepository
import com.volundes.bancha.domain.repository.SubtitleRepository
import org.springframework.stereotype.Component
import java.lang.Math.abs
import java.util.*

@Component
class MenuProvider(
        private val menuRepository: MenuRepository
) {

    fun get() = menuRepository.get()

}