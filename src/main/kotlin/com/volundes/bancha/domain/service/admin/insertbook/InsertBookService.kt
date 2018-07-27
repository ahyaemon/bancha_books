package com.volundes.bancha.domain.service.admin.insertbook

import com.volundes.bancha.domain.dto.InsertBook
import com.volundes.bancha.domain.dto.RawBook
import com.volundes.bancha.domain.dto.Sentence
import com.volundes.bancha.domain.repository.BookRepository
import com.volundes.bancha.infra.entity.SentenceEntity
import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class InsertBookService(
        private val bookRepository: BookRepository
) {

    fun addFile(rawBook: RawBook){
        val parser = RawBookParser(rawBook)

        val title = parser.getTitle()
        val author = parser.getAuthor()
        val sentences = parser
                .getSentences()
                .map{
                    Sentence(null, it, listOf(), listOf())
                }
        val insertBook = InsertBook(null, title, author, sentences)
        bookRepository.addBook(insertBook)

    }

}