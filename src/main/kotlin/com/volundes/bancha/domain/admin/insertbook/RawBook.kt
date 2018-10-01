package com.volundes.bancha.domain.admin.insertbook

import org.springframework.web.multipart.MultipartFile
import java.nio.charset.Charset

data class RawBook(
        val content: String
) {

    companion object {
        fun fromFile(file: MultipartFile, encode: String): RawBook {
            val content = String(file.bytes, Charset.forName(encode))
            return RawBook(content)
        }
    }

}