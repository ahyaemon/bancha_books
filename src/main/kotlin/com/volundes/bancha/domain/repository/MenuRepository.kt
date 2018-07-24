package com.volundes.bancha.domain.repository

import com.volundes.bancha.domain.dto.*
import com.volundes.bancha.infra.dao.*
import com.volundes.bancha.infra.mapper.*
import org.springframework.stereotype.Repository

@Repository
class MenuRepository(
        private val menuDao: MenuDao,
        private val menuMapper: MenuInfraMapper
) {

    private var menus: List<Menu> = emptyList()

    fun get(): List<Menu>{
        if(menus.isEmpty()) {
            menus = menuMapper.toMenu(menuDao.select())
        }
        return menus
    }

}