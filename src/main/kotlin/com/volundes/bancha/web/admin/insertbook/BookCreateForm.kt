package com.volundes.bancha.web.admin.insertbook

import org.springframework.web.multipart.MultipartFile

data class BookCreateForm(
        val title: String,
        val authorId: Long,
        val licenseType: String,
        val licenseNotice: String,
        val file: MultipartFile?
) {

    companion object {
        fun default(): BookCreateForm {
            return BookCreateForm("", 1, "None", "", null)
        }
    }

}