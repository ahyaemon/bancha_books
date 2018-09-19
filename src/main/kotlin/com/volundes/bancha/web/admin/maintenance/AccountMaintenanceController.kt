package com.volundes.bancha.web.admin.maintenance

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/maintenance/account")
class AccountMaintenanceController {

    /**
     * indexへのマッピングです。
     */
    @RequestMapping
    fun index(): String {
        return "admin/maintenance/account/index"
    }
}