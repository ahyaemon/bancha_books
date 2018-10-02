package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.`object`.book.*
import com.volundes.bancha.domain.`object`.bookmenu.BookMenu
import com.volundes.bancha.domain.`object`.paging.Page
import com.volundes.bancha.infra.dao.*
import com.volundes.bancha.infra.mapper.*
import org.springframework.stereotype.Repository

@Repository
class BookRepository(
        private val bookDao: BookDao,
        private val sentenceDao: SentenceDao,
        private val commentDao: CommentDao,
        private val authorDao: AuthorDao,
        private val licenseDao: LicenseDao
):
        Pageable,
        CommentMapperExtension,
        SentenceMapperExtension,
        BookMapperExtension,
        LicenseMapperExtension,
        AuthorMapperExtension
{

    fun getBookMenus(page: Page): List<BookMenu>{
        return bookDao
                .selectBookMenu(page.toSelectOptions())
                .toBookMenus()
    }

    fun getCommentCountedBookByBookId(
            bookId: Long,
            page: Page
    ): CommentCountedBook {
        val selectOptions = page.toSelectOptions()
        return bookDao
                .selectBookSummaryByBookId(bookId, selectOptions)
                .toCommentCountedBook()
    }

    fun insertComment(sentenceId: Long, comment: Comment) {
        // commentの登録
        val commentEntity = comment.toEntity(sentenceId)
        commentDao.insert(commentEntity)
    }

    fun addBook(book: Book){
        // Author
        val authorEntityInDB = authorDao.selectByName(book.author.name)
        val authorExists = authorEntityInDB != null
        if(!authorExists){
            val authorEntity = book.author.toAuthorEntity()
            authorDao.insert(authorEntity)
        }
        val authorId =
                if (authorExists) {
                    authorEntityInDB.id
                }
                else{
                    // 一旦INSERTしたものを抜き出し、IDを得る
                    // TODO トランザクションレベルの考慮が必要
                    authorDao.selectByName(book.author.name).id
                }

        // Book
        val bookEntity = book.toBookEntity(authorId)
        bookDao.insert(bookEntity)

        //Sentence
        val insertedBookId = bookDao.selectBookIdByNameAndAuthorId(book.name, authorId)
        val sentenceEntities = book.sentences.toTables(insertedBookId)
        sentenceDao.insert(sentenceEntities)

        // License
        if(book.license != null){
            val licenseTable = book.license.toTable(insertedBookId)
            licenseDao.insert(licenseTable)
        }
    }

    fun getSentencesBySentenceId(
            sentenceId: Long,
            page: Page
    ): Sentence {
        val selectOptions = page.toSelectOptions()
        return sentenceDao
                .selectSentenceSummaryBySentenceId(sentenceId, selectOptions)
                .toSentence()
    }

    fun getTotalBookAmount(): Int {
        return bookDao.countBook()
    }

    fun getTotalSentenceAmount(bookId: Long): Int {
        return sentenceDao.countSentenceByBookId(bookId)
    }

    fun getTotalCommentAmount(sentenceId: Long): Int {
        return commentDao.countCommentBySentenceId(sentenceId)
    }

    /**
     * 著者のリストを取得します。
     */
    fun getAuthors(): List<Author> {
        return authorDao.select().map{ it.toAuthor() }
    }

    /**
     * ライセンスを登録します。
     */
    fun addLicense(license: License, bookId: Long) {
        val licenseTable = license.toTable(bookId)
        licenseDao.insert(licenseTable)
    }

}