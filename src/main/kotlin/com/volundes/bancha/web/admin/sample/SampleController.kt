package com.volundes.bancha.web.admin.sample

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/sample")
class SampleController {

    @RequestMapping
    fun index(): String {
        return "admin/sample/index"
    }

}