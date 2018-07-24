package com.volundes.bancha.web.controller.donation

import com.volundes.bancha.domain.provider.SubtitleProvider
import com.volundes.bancha.domain.service.DonationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/donation")
class DonationController(
        private val subtitleProvider: SubtitleProvider,
        private val service: DonationService
) {

    @ModelAttribute("subtitle")
    fun subtitle(): String{
        return subtitleProvider.get("donation")
    }

    @RequestMapping("/")
    fun index(model: Model): String{
        val testPayForm = TestPayForm()
        model.addAttribute("testPayForm", testPayForm)

        val totalAmount = service.sum()
        model.addAttribute("totalAmount", totalAmount)
        model.addAttribute("donated", false)

        return "donation/index"
    }

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

}