package com.volundes.bancha.web.admin.insertbook

import com.volundes.bancha.domain.book.Author
import com.volundes.bancha.domain.book.Book
import com.volundes.bancha.domain.book.Sentence
import com.volundes.bancha.domain.book.service.License
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
        val author = authors.first{ it.authorId == authorId }
        val license = if(licenseType == "None"){
            null
        }else{
            License(null, licenseNotice, licenseType)
        }
        return Book(null, title, author, license, sentences)
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