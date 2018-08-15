package com.volundes.bancha.web.donation

import com.volundes.bancha.domain.donation.DonationService
import com.volundes.bancha.env.interceptor.subtitle.DynamicSubtitle
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

/**
 * 「寄付」ページを担うControllerです。
 */
@Controller
@RequestMapping("/donation")
@DynamicSubtitle("donation")
class DonationController(
        private val service: DonationService
) {

    /**
     * indexへのマッピングです。
     */
    @RequestMapping("/")
    fun index(model: Model): String{
        val testPayForm = TestPayForm("", "", "0")
        model.addAttribute("testPayForm", testPayForm)

        val totalAmount = service.sum().toString()
        model.addAttribute("totalAmount", totalAmount)
        model.addAttribute("donated", false)

        return "donation/index"
    }

    /**
     * TestPay実行結果を登録します。
     */
    @RequestMapping("/pay")
    fun pay(
            @ModelAttribute @Validated testPayForm: TestPayForm?,
            result: BindingResult,
            model: Model
    ): String{
        if(result.hasErrors()){
            val totalAmount = service.sum()
            model.addAttribute("totalAmount", totalAmount)
            model.addAttribute("donated", false)
            return "donation/index"
        }
        service.add(testPayForm!!.toDonation())
        val totalAmount = service.sum()
        model.addAttribute("totalAmount", totalAmount)
        model.addAttribute("donated", true)
        return "donation/index"
    }

    /**
     * 寄付詳細へのマッピングです。
     */
    @RequestMapping("/detail")
    fun detail(
            model: Model
    ): String{
        val donations = service.getDonations()
        val donationItems = donations.map{ DonationItem(it) }
        model.addAttribute("donationItems", donationItems)
        return "donation/detail"
    }

}