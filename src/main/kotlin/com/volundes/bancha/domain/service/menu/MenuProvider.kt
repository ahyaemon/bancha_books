package com.volundes.bancha.domain.service.menu

import com.volundes.bancha.infra.repository.MenuRepository
import org.springframework.stereotype.Component

/**
 * トップメニューを取得するためのProviderです。
 */
@Component
class MenuProvider(
        private val menuRepository: MenuRepository
) {

    fun get() = menuRepository.get()

}