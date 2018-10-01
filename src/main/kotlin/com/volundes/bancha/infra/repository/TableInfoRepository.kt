package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.admin.download.TableInfo
import com.volundes.bancha.infra.dao.TableInfoDao
import com.volundes.bancha.infra.mapper.TableInfoMapperExtension
import org.springframework.stereotype.Repository

@Repository
class TableInfoRepository(
        private val tableInfoDao: TableInfoDao
):
        TableInfoMapperExtension
{

    fun getTableInfo(): List<TableInfo> {
        return tableInfoDao.select().toTableInfos()
    }

}