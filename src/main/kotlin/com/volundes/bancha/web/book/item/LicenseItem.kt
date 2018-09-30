package com.volundes.bancha.web.book.item

import com.volundes.bancha.domain.book.service.License

data class LicenseItem(
        val licenseId: Long,
        val notice: String,
        val licenseType: String
) {

    constructor(license: License): this(license.licenseId, license.notice, license.licenseType)

}