package com.volundes.bancha.web.general.register

import com.volundes.bancha.domain.general.profile.Hitokoto
import com.volundes.bancha.domain.general.register.GeneralRegisterService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/thank-you-for-register")
class GeneralRegisterController(
        private val generalRegisterService: GeneralRegisterService
) {

    /**
     * indexへのマッピングです。
     * sendMail時に発行した urlKay が存在する場合に、登録ページを返します。
     * 存在しない場合はエラーページを返します。
     */
    @RequestMapping("/{urlKey}")
    fun index(
            @PathVariable("urlKey") urlKey: String,
            model: Model
    ): String {
        // urlKeyがDBに存在しない場合、エラーページを返す
        if(!generalRegisterService.existsUrlKey(urlKey)){
            return "general/register/not_exists_url_key"
        }

        val mailAddress = generalRegisterService.getMailAddress(urlKey)
        val accountCreateForm = AccountCreateForm(mailAddress, "", "", "", "")
        model.addAttribute("accountCreateForm", accountCreateForm)
        return "general/register/index"
    }

    /**
     * 会員を新規登録します。
     */
    @RequestMapping("/create")
    fun create(
            accountCreateForm: AccountCreateForm,
            model: Model
    ): String {
        // TODO バリデーション

        val account = accountCreateForm.toAccount()
        generalRegisterService.addAccount(account)

        val accountId = generalRegisterService.getAccountId(account)
        val hitokoto = Hitokoto(null, accountCreateForm.hitokoto)
        generalRegisterService.addHitokoto(accountId, hitokoto)

        return "general/register/done"
    }

}