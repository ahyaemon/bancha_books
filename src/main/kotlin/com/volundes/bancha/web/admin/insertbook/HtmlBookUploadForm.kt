package com.volundes.bancha.web.admin.insertbook

import org.springframework.web.multipart.MultipartFile

data class HtmlBookUploadForm(
        var file: MultipartFile? = null
) {

    companion object {
        fun default(): HtmlBookUploadForm {
            return HtmlBookUploadForm()
        }
    }

}