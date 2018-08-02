package com.volundes.bancha.web.admin.insertbook

import com.volundes.bancha.domain.admin.insertbook.RawBook
import com.volundes.bancha.domain.admin.insertbook.InsertBookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import java.nio.charset.Charset

@Controller
@RequestMapping("/admin/insertbook")
class InsertBookController(
        private val service: InsertBookService
) {

    @RequestMapping("/")
    fun index(
            model: Model
    ): String{
        val htmlBookUploadForm = HtmlBookUploadForm()
        model.addAttribute("htmlBookUploadForm", htmlBookUploadForm)

        return "admin/insertbook/index"
    }

    @RequestMapping("/html")
    fun insertHtml(
            @Validated htmlBookUploadForm: HtmlBookUploadForm,
            result: BindingResult
    ): String{
        val rawBook = createRowBook(htmlBookUploadForm)
        service.addBook(rawBook)
        return "admin/insertbook/index"
    }

    private fun createRowBook(htmlBookUploadForm: HtmlBookUploadForm): RawBook {
        val encode = "Shift-JIS"
        val content = String(htmlBookUploadForm.file!!.bytes, Charset.forName(encode))
        return RawBook(content)
    }

}