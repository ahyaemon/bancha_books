package com.volundes.bancha.web.admin.maintenance.book

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/maintenance/book")
class BookMaintenanceController {

    /**
     * indexへのマッピングです。
     */
    @RequestMapping
    fun index(): String {
        return "admin/maintenance/book/index"
    }
    
}