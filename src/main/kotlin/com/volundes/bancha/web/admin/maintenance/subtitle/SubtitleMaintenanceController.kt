package com.volundes.bancha.web.admin.maintenance.subtitle

import com.volundes.bancha.domain.service.admin.maintenance.subtitle.SubtitleMaintenanceService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

/**
 * サブタイトルを管理します。
 * 変更がある場合は、{@link SubtitleRepository} も更新する必要があります。
 */
@Controller
@RequestMapping("/admin/maintenance/subtitle")
class SubtitleMaintenanceController(
        private val service: SubtitleMaintenanceService
) {

    /**
     * indexへのマッピングです。
     */
    @RequestMapping
    fun index(model: Model): String {
        val subtitleMaintenanceItems = service.getSubtitles().map{ SubtitleMaintenanceItem(it) }
        model.addAttribute("subtitleMaintenanceItems", subtitleMaintenanceItems)
        return "admin/maintenance/subtitle/index"
    }

}