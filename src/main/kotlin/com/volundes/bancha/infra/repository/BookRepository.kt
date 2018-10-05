package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.obj.book.*
import com.volundes.bancha.domain.page.Page
import com.volundes.bancha.infra.dao.*
import com.volundes.bancha.infra.entity.CommentCountedSentenceEntity
import com.volundes.bancha.infra.mapper.*
import org.springframework.stereotype.Repository

@Repository
class BookRepository(
        private val bookDao: BookDao,
        private val bookInfoDao: BookInfoDao,
        private val sentenceDao: SentenceDao,
        private val commentDao: CommentDao,
        private val authorDao: AuthorDao,
        private val licenseDao: LicenseDao
):
        Pageable,
        CommentMapperExtension,
        SentenceMapperExtension,
        BookMapperExtension,
        BookInfoMapperExtension,
        LicenseMapperExtension,
        AuthorMapperExtension
{

    fun getBookInfos(page: Page): List<BookInfo>{
        return bookInfoDao
                .selectEntity(page.toSelectOptions())
                .toBookInfos()
    }

    /**
     * bookIdに対応するBookと、コメント数を取得します。
     * 実際のコメントは取得しません。
     */
    fun getWithCommentCountMap(
            bookId: Long,
            page: Page
    ): Pair<Book, Map<Long, Long>> {
        val entity =
                bookDao.selectEntityByIdWithoutComment(page.toSelectOptions(), bookId)
        val book = entity.toBook()
        val sentenceIds = entity.map{ it.sentenceId }
        val commentCount = sentenceDao.countSentenceComment(sentenceIds)
        val commentCountMap = commentCount.toCommentCountMap()
        return Pair(book, commentCountMap)
    }

    private fun List<CommentCountedSentenceEntity>.toCommentCountMap(): Map<Long, Long> {
        val m = mutableMapOf<Long, Long>()
        forEach{ m.put(it.sentenceId, it.commentCount)}
        return m
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
        val authorEntityInDB = authorDao.selectByName(book.bookInfo.author.name)
        val authorExists = authorEntityInDB != null
        if(!authorExists){
            val authorEntity = book.bookInfo.author.toAuthorEntity()
            authorDao.insert(authorEntity)
        }
        val authorId =
                if (authorExists) {
                    authorEntityInDB.id
                }
                else{
                    // 一旦INSERTしたものを抜き出し、IDを得る
                    // TODO トランザクションレベルの考慮が必要
                    authorDao.selectByName(book.bookInfo.author.name).id
                }

        // Book
        val bookEntity = book.toBookEntity(authorId)
        bookDao.insert(bookEntity)

        //Sentence
        val insertedBookId = bookDao.selectBookIdByNameAndAuthorId(book.bookInfo.title, authorId)
        val sentenceEntities = book.sentences.toTables(insertedBookId)
        sentenceDao.insert(sentenceEntities)

        // License
        if(book.bookInfo.license != null){
            val licenseTable = book.bookInfo.license.toTable(insertedBookId)
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