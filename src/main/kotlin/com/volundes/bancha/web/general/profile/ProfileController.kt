package com.volundes.bancha.web.general.profile

import com.volundes.bancha.domain.account.Account
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("profile")
class ProfileController {

    @RequestMapping("{accountId}")
    fun index(
            @PathVariable("accountId") accountId: String,
            @ModelAttribute(binding = false) account: Account?
    ): String{
        if(account == null){
            return "general/profile/others/index"
        }

        if(!account.canEdit(accountId)){
            return "general/profile/others/index"
        }

        return "general/profile/mine/index"
    }

    private fun Account.canEdit(otherId: String): Boolean {
        return this.accountId == otherId.toLong()
    }

}