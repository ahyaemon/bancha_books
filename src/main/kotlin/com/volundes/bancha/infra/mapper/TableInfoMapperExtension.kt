package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.admin.download.TableInfo
import com.volundes.bancha.infra.entity.table.TableInfoTable
import org.springframework.stereotype.Component

@Component
interface TableInfoMapperExtension {

    fun TableInfoTable.toTableInfo() = TableInfo(tableInfoId, name, version)
    fun List<TableInfoTable>.toTableInfos() = map{ it.toTableInfo() }

}