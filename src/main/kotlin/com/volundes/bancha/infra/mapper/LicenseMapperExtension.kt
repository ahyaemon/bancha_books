package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.obj.book.License
import com.volundes.bancha.infra.entity.table.LicenseTable

interface LicenseMapperExtension {

    fun License.toTable(bookId: Long) = LicenseTable(id, bookId.toInt(), licenseType, notice)

}