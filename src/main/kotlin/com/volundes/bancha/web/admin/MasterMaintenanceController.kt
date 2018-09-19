package com.volundes.bancha.web.admin

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/maintenance")
class MasterMaintenanceController {

    /**
     * indexへのマッピングです。
     */
    @RequestMapping
    fun index(): String {
        return "admin/maintenance/index"
    }
    
}