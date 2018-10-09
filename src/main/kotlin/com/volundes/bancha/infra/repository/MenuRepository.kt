package com.volundes.bancha.infra.repository

import com.volundes.bancha.infra.dao.MenuDao
import com.volundes.bancha.infra.mapper.MenuMapperExtension
import org.springframework.stereotype.Repository

@Repository
class MenuRepository(
        private val menuDao: MenuDao
):
        MenuMapperExtension
{

    private val menus by lazy { menuDao.select().toMenus() }

    fun find() = menus

}