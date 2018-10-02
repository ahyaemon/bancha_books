package com.volundes.bancha.web.book.item

import com.volundes.bancha.domain.`object`.book.License

data class LicenseItem(
        val licenseId: Long?,
        val notice: String,
        val licenseType: String
) {

    constructor(license: License): this(license.id, license.notice, license.licenseType)

}