package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.menu.Menu
import com.volundes.bancha.infra.entity.table.MenuTable
import org.springframework.stereotype.Component

@Component
class MenuInfraMapper {

    fun toMenu(entity: MenuTable): Menu {
        return Menu(entity.menuId, entity.title, entity.subtitle, entity.url)
    }

    fun toMenu(entities: List<MenuTable>): List<Menu>{
        return entities.map{ toMenu(it) }
    }

}