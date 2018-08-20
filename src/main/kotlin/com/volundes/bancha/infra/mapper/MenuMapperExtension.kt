package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.menu.Menu
import com.volundes.bancha.infra.entity.table.MenuTable
import org.springframework.stereotype.Component

@Component
interface MenuMapperExtension {

    fun MenuTable.toMenu() =  Menu(menuId, title, subtitle, url)
    fun List<MenuTable>.toMenus() = map{ it.toMenu() }

}