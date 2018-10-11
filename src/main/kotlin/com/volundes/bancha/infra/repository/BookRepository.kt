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

    fun findBookInfos(page: Page): List<BookInfo>{
        return bookInfoDao
                .selectEntity(page.toSelectOptions())
                .toBookInfos()
    }

    /**
     * bookIdに対応するBookと、コメント数を取得します。
     * 実際のコメントは取得しません。
     */
    fun findWithCommentCountMap(
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

    fun addComment(sentenceId: Long, comment: Comment) {
        // commentの登録
        val commentEntity = comment.toEntity(sentenceId)
        commentDao.insert(commentEntity)
    }

    fun addBook(book: Book){
        // Author
        val authorTableInDB = authorDao.selectByName(book.bookInfo.author.name)
        val authorExists = authorTableInDB != null
        if(!authorExists){
            val authorTable = book.bookInfo.author.toAuthorEntity()
            authorDao.insert(authorTable)
        }
        val authorId =
                if (authorExists) {
                    authorTableInDB.id
                }
                else{
                    authorDao.selectByName(book.bookInfo.author.name).id
                }

        // BookInfo
        val bookInfoTable = book.bookInfo.toTable()
        val insertedBookInfoTable = bookInfoDao.insert(bookInfoTable)
        val bookInfoId = insertedBookInfoTable.entity.id

        // Book
        val bookTable = book.toTable(bookInfoId)
        bookDao.insert(bookTable)

        //Sentence
        val insertedBookId = bookDao.selectBookIdByNameAndAuthorId(book.bookInfo.title, authorId)
        val sentenceTables = book.sentences.toTables(insertedBookId)
        sentenceDao.insert(sentenceTables)

        // License
        if(book.bookInfo.license != null){
            val licenseTable = book.bookInfo.license.toTable(insertedBookId)
            licenseDao.insert(licenseTable)
        }
    }

    fun findSentencesBySentenceId(
            sentenceId: Long,
            page: Page
    ): Sentence {
        val selectOptions = page.toSelectOptions()
        return sentenceDao
                .selectSentenceSummaryBySentenceId(sentenceId, selectOptions)
                .toSentence()
    }

    fun findTotalBookAmount(): Int {
        return bookDao.countBook()
    }

    fun findTotalSentenceAmount(bookId: Long): Int {
        return sentenceDao.countSentenceByBookId(bookId)
    }

    fun findTotalCommentAmount(sentenceId: Long): Int {
        return commentDao.countCommentBySentenceId(sentenceId)
    }

    /**
     * 著者のリストを取得します。
     */
    fun findAuthors(): List<Author> {
        return authorDao.select().map{ it.toAuthor() }
    }

}