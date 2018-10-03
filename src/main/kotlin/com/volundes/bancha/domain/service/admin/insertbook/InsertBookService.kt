package com.volundes.bancha.domain.service.admin.insertbook

import com.volundes.bancha.domain.obj.book.Author
import com.volundes.bancha.domain.obj.book.Book
import com.volundes.bancha.infra.repository.BookRepository
import org.springframework.stereotype.Service

/**
 * 新しい本の追加を担うServiceです。
 */
@Service
class InsertBookService(
        private val bookRepository: BookRepository
) {

//    /**
//     * rawBookを タイトル/著者/文 に分けて永続化します。
//     *
//     * @param[rawBook] 青空文庫形式のRawBookのインスタンス
//     */
//    fun addBook(rawBook: RawBook){
//        val parser = RawBookParser(rawBook)
//
//        val title = parser.getTitle()
//        val author = Author(null, parser.getAuthor())
//        val sentences = parser
//                .getSentences()
//                .map{
//                    Sentence(null, it, 7, listOf())
//                }
//        val book = Book(null, title, author, null, sentences)
//        bookRepository.addBook(book)
//
//    }

    /**
     * Bookを登録します。
     */
    fun addBook(book: Book){
        bookRepository.addBook(book)
    }

    /**
     * 著者のリストを取得します
     */
    fun getAuthors(): List<Author> {
        return bookRepository.getAuthors()
    }

}