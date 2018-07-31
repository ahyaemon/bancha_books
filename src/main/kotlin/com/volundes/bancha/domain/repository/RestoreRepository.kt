package com.volundes.bancha.domain.repository

import com.volundes.bancha.infra.dao.RestoreDao
import org.springframework.stereotype.Repository

@Repository
class RestoreRepository(
        private val restoreDao: RestoreDao
) {

    fun restore(){
        restoreDao.restore()
    }

}