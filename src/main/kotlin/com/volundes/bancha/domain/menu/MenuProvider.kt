package com.volundes.bancha.domain.menu

import com.volundes.bancha.infra.repository.MenuRepository
import org.springframework.stereotype.Component

@Component
class MenuProvider(
        private val menuRepository: MenuRepository
) {

    fun get() = menuRepository.get()

}