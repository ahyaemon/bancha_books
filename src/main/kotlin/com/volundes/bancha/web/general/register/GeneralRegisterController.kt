package com.volundes.bancha.web.general.register

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/thank-you-for-register")
class GeneralRegisterController {

    /**
     * indexへのマッピングです。
     * sendMail時に発行した urlKay が存在する場合に、登録ページを返します。
     * 存在しない場合はエラーページを返します。
     */
    @RequestMapping("/{urlKey}")
    fun index(
            @PathVariable("urlKey") urlKey: String
    ): String {

        // DBに存在するurlKeyか確認する。


        return "general/register/index"
    }


}