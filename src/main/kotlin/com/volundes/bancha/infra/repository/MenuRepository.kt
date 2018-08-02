package com.volundes.bancha.infra.repository

import com.volundes.bancha.infra.dao.MenuDao
import com.volundes.bancha.infra.mapper.MenuInfraMapper
import org.springframework.stereotype.Repository

@Repository
class MenuRepository(
        private val menuDao: MenuDao,
        private val menuMapper: MenuInfraMapper
) {

    private val menus by lazy { menuMapper.toMenu(menuDao.select()) }

    fun get() = menus

}