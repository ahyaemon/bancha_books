package com.volundes.bancha.web.general.profile

import com.volundes.bancha.domain.obj.account.Account
import com.volundes.bancha.domain.service.general.profile.ProfileService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession

@Controller
@RequestMapping("profile")
class ProfileController(
        private val service: ProfileService
) {

    /**
     * indexへのマッピングです。
     */
    @RequestMapping("{id}")
    fun index(
            @PathVariable("id") accountId: String,
            @ModelAttribute(binding = false) account: Account?,
            model: Model
    ): String{
        /*
         * ほかの人の情報
         */
        if(!account.canEdit(accountId)){
            val profile = service.getProfile(accountId.toLong())
            val profileItem = ProfileItem(profile)
            model.addAttribute("profileItem", profileItem)
            return "general/profile/others/index"
        }

        /*
         * 自分の情報
         */
        val hitokoto = service.getHitokoto(accountId.toLong())
        // hitokotoは存在しない場合がある
        val profileEditForm =
                if(hitokoto == null){
                    ProfileEditForm(account!!)
                }
                else{
                    ProfileEditForm(account!!, hitokoto)
                }
        model.addAttribute("profileEditForm", profileEditForm)
        return "general/profile/mine/index"
    }

    private fun Account?.canEdit(otherId: String): Boolean {
        if(this == null){
            return false
        }
        return this.id == otherId.toLong()
    }

    /**
     * 自分の情報を編集します。
     */
    @RequestMapping("/edit")
    fun edit(
            @Validated profileEditForm: ProfileEditForm,
            result: BindingResult,
            @ModelAttribute(binding = false) account: Account?,
            model: Model,
            httpSession: HttpSession
    ): String {
        // TODO accountがnullの場合（ありえないけど。。）
        if(account == null){
            return "/"
        }

        // TODO バリデーションエラー時の動作

        // 登録
        val profile = profileEditForm.toProfile(account)
        service.editProfile(profile)

        // sessionn中のaccountも更新
        val newAccount = account.copy(
                nickname = profileEditForm.nickname,
                email = profileEditForm.email
        )
        httpSession.setAttribute("account", newAccount)

        val accountId = account.id
        return "redirect:/profile/$accountId"
    }

}