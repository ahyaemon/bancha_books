package com.volundes.bancha.web.admin.insertbook

import com.volundes.bancha.domain.admin.insertbook.RawBook
import com.volundes.bancha.domain.admin.insertbook.InsertBookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import java.nio.charset.Charset

/**
 * 「本の追加」画面を担うControllerです。
 */
@Controller
@RequestMapping("/admin/insertbook")
class InsertBookController(
        private val service: InsertBookService
) {

    /**
     * indexへのマッピングです。
     */
    @RequestMapping("/")
    fun index(
            model: Model
    ): String{
        model.addAttribute("htmlBookUploadForm", HtmlBookUploadForm.default())
        model.addAttribute("bookCreateForm", BookCreateForm.default())
        return "admin/insertbook/index"
    }

    /**
     * ajax。
     * html形式でpostされた本を新規追加します。
     */
    @RequestMapping("/html")
    fun insertHtml(
            @Validated form: HtmlBookUploadForm,
            result: BindingResult
    ): String{
        val rawBook = RawBook.fromFile(form.file!!, "Shift-JIS")
        service.addBook(rawBook)
        return "admin/insertbook/index"
    }

    /**
     * 手動入力で本を新規登録します。
     */
    @RequestMapping("/create")
    fun create(
            form: BookCreateForm
    ): String {

        return "redirect:/admin/insertbook/"
    }

}