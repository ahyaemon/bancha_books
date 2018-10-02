package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.vo.admin.download.TableInfo
import com.volundes.bancha.infra.entity.table.TableInfoTable
import org.springframework.stereotype.Component

@Component
interface TableInfoMapperExtension {

    fun TableInfoTable.toTableInfo() = TableInfo(id, name, version)
    fun List<TableInfoTable>.toTableInfos() = map{ it.toTableInfo() }

}