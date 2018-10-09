package com.volundes.bancha.web.admin.maintenance.book.insertbook

import com.volundes.bancha.domain.obj.book.*
import org.springframework.web.multipart.MultipartFile
import java.nio.charset.Charset

data class BookCreateForm(
        val title: String,
        val authorId: Long,
        val licenseType: String,
        val licenseNotice: String,
        var file: MultipartFile?
) {

    companion object {
        fun default(): BookCreateForm {
            return BookCreateForm("", 1, "None", "", null)
        }
    }

    fun tobook(authors: List<Author>, encode: String): Book {
        val sentences = createSentences(file!!, encode)
        val author = authors.first{ it.id == authorId }
        val license = if(licenseType == "None"){
            null
        }else{
            License(null, licenseNotice, licenseType)
        }
        val bookInfo = BookInfo(null, title, author, license)
        return Book(null, bookInfo, sentences)
    }

    private fun createSentences(file: MultipartFile, encode: String): List<Sentence> {
        val content = String(file.bytes, Charset.forName(encode))
        val lines = content
                .replace("\r\n", "\n")
                .split("\n")
                .filter{ it != "" }
        val sentences = lines.map { line ->
            val (sentence, heading) = line.split("\t")
            Sentence(null, sentence, heading.toInt(), listOf())
        }
        return sentences
    }

}