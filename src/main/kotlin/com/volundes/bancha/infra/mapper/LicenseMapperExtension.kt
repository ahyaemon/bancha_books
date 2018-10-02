package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.`object`.book.License
import com.volundes.bancha.infra.entity.table.LicenseTable

interface LicenseMapperExtension {

    fun License.toTable(bookId: Long): LicenseTable {
        val table = LicenseTable()
        table.id = licenseId
        table.bookId = bookId
        table.licenseType = licenseType
        table.notice = notice

        return table
    }

}