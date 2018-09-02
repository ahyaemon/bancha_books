package com.volundes.bancha.web.general.profile

import com.volundes.bancha.domain.account.Account
import com.volundes.bancha.domain.general.profile.ProfileService
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("profile")
class ProfileController(
        private val service: ProfileService
) {

    @RequestMapping("{accountId}")
    fun index(
            @PathVariable("accountId") accountId: String,
            @ModelAttribute(binding = false) account: Account?,
            model: Model
    ): String{
        if(account == null){
            return "general/profile/others/index"
        }

        if(!account.canEdit(accountId)){
            return "general/profile/others/index"
        }

        val hitokoto = service.getHitokoto(accountId.toLong())
        val profileEditForm = ProfileEditForm(account, hitokoto)
        model.addAttribute("profileEditForm", profileEditForm)
        return "general/profile/mine/index"
    }

    private fun Account.canEdit(otherId: String): Boolean {
        return this.accountId == otherId.toLong()
    }

}