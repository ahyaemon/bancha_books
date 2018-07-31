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

    private val menus by lazy { menuMapper.toMenu(menuDao.select()) }

    fun get() = menus

}