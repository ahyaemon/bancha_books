package com.volundes.bancha.web.admin.restore

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/restore")
class RestoreController {

    /**
     * indexへのマッピングです。
     */
    @RequestMapping
    fun index(): String {
        return "admin/restore/index"
    }
    
}