package com.volundes.bancha.web.admin.maintenance.account

import com.volundes.bancha.domain.service.admin.maintenance.account.AccountMaintenanceService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/maintenance/account")
class AccountMaintenanceController(
        private val service: AccountMaintenanceService
) {

    /**
     * indexへのマッピングです。
     */
    @RequestMapping
    fun index(model: Model): String {
        return "admin/maintenance/account/index"
    }

}