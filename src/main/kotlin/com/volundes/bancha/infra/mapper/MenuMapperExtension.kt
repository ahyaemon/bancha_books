package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.obj.menu.Menu
import com.volundes.bancha.infra.entity.table.MenuTable
import org.springframework.stereotype.Component

@Component
interface MenuMapperExtension {

    fun MenuTable.toMenu() = Menu(id, title, subtitle, url)
    fun List<MenuTable>.toMenus() = map{ it.toMenu() }

}