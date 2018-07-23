package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.dto.Account
import com.volundes.bancha.domain.dto.Menu
import com.volundes.bancha.domain.dto.Subtitle
import com.volundes.bancha.infra.entity.AccountEntity
import com.volundes.bancha.infra.entity.MenuEntity
import org.springframework.stereotype.Component

@Component
class MenuInfraMapper {

    fun toMenu(entity: MenuEntity): Menu {
        return Menu(entity.menuId, entity.title, entity.subtitle, entity.url)
    }

    fun toMenu(entities: List<MenuEntity>): List<Menu>{
        return entities.map{ toMenu(it) }
    }

}