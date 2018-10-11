package com.volundes.bancha.web.admin.maintenance.book.insertbook

import com.volundes.bancha.domain.service.admin.maintenance.book.insertbook.InsertBookService
import com.volundes.bancha.domain.obj.book.Author
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.SessionAttributes

/**
 * 「本の追加」画面を担うControllerです。
 */
@Controller
@RequestMapping("/admin/insertbook")
@SessionAttributes("authors")
class InsertBookController(
        private val service: InsertBookService
) {

    /**
     * authorsをセッションで管理します。
     */
    @ModelAttribute("authors")
    fun authors(): List<Author> {
        return service.getAuthors()
    }

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
//    @RequestMapping("/html")
//    fun insertHtml(
//            @Validated form: HtmlBookUploadForm,
//            result: BindingResult
//    ): String{
//        val rawBook = RawBook.fromFile(form.file!!, "Shift-JIS")
//        service.addBook(rawBook)
//        return "admin/insertbook/index"
//    }

    /**
     * 手動入力で本を新規登録します。
     * TODO 既に同じ本が入っているか確認する
     */
    @RequestMapping("/create")
    fun create(
            form: BookCreateForm,
            result: BindingResult,
            @ModelAttribute(value="authors", binding = false) authors: List<Author>
    ): String {
        val book = form.tobook(authors, "UTF-8")
        service.addBook(book)

        return "redirect:/admin/insertbook/"
    }

}