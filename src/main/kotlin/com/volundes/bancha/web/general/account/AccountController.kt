package com.volundes.bancha.web.general.account

import com.volundes.bancha.domain.obj.account.Account
import com.volundes.bancha.domain.service.general.profile.AccountService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession

@Controller
@RequestMapping("account")
class AccountController(
        private val service: AccountService
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
            val otherAccount = service.getAccount(accountId.toLong())
            val accountItem = AccountItem(otherAccount)
            model.addAttribute("accountItem", accountItem)
            return "general/account/others/index"
        }

        /*
         * 自分の情報
         */
        val accountEditForm = AccountEditForm(account!!)
        model.addAttribute("accountEditForm", accountEditForm)
        return "general/account/mine/index"
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
    @RequestMapping("/update")
    fun edit(
            @Validated accountEditForm: AccountEditForm,
            result: BindingResult,
            @ModelAttribute(binding = false) account: Account?,
            model: Model,
            httpSession: HttpSession
    ): String {
        // TODO バリデーションエラー時の動作

        // 登録
        val newAccount = accountEditForm.toAccount(account!!)
        service.editAccount(newAccount)
        httpSession.setAttribute("account", newAccount)
        return "redirect:/account/${account.id}"
    }

}