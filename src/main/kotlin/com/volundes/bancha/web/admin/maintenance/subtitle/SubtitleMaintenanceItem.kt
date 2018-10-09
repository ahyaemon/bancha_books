package com.volundes.bancha.web.admin.maintenance.subtitle

import com.volundes.bancha.domain.obj.subtitle.Subtitle

data class SubtitleMaintenanceItem(
        val subtitleId: String,
        val titleCd: String,
        val subtitleValue: String
) {

    constructor(subtitle: Subtitle): this(
            subtitle.id!!.toString(),
            subtitle.titleCd,
            subtitle.value
    )

}