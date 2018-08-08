package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.book.Book
import com.volundes.bancha.domain.book.BookInfo
import com.volundes.bancha.domain.book.Comment
import com.volundes.bancha.domain.book.Sentence
import com.volundes.bancha.infra.dao.AuthorDao
import com.volundes.bancha.infra.dao.BookDao
import com.volundes.bancha.infra.dao.CommentDao
import com.volundes.bancha.infra.dao.SentenceDao
import com.volundes.bancha.infra.mapper.AuthorInfraMapper
import com.volundes.bancha.infra.mapper.BookInfraMapper
import com.volundes.bancha.infra.mapper.CommentInfraMapper
import com.volundes.bancha.infra.mapper.SentenceInfraMapper
import org.springframework.stereotype.Repository

@Repository
class BookRepository(
        private val bookDao: BookDao,
        private val sentenceDao: SentenceDao,
        private val commentDao: CommentDao,
        private val authorDao: AuthorDao,
        private val bookMapper: BookInfraMapper,
        private val sentenceMapper: SentenceInfraMapper,
        private val commentMapper: CommentInfraMapper,
        private val authorMapper: AuthorInfraMapper
) {

    fun getBookMenus() = bookDao.selectBookMenu().map{ bookMapper.toBookMenu(it)}

    fun getBookByBookId(bookId: Long): Book {
        val bookSummaryEntity = bookDao.selectBookSummaryByBookId(bookId)
        val book = bookMapper.toBook(bookSummaryEntity)
        return book
    }

    fun insertComment(sentenceId: Long, comment: Comment) {
        val entity = commentMapper.toEntity(sentenceId, comment)
        commentDao.insert(entity)
    }

    fun getCommentsBySentenceId(sentenceId: Long): List<Comment> {
        val entities = sentenceDao.selectCommentBySentenceId(sentenceId)
        return sentenceMapper.toComment(entities)
    }

    fun addBook(book: Book){
        // Author
        val authorEntityInDB = authorDao.selectByName(book.author.name)
        val authorExists = authorEntityInDB != null
        if(!authorExists){
            val authorEntity = authorMapper.toAuthorEntity(book.author)
            authorDao.insert(authorEntity)
        }
        val authorId =
                if (authorExists) {
                    authorEntityInDB.authorId
                }
                else{
                    // 一旦INSERTしたものを抜き出し、IDを得る
                    // TODO トランザクションレベルの考慮が必要？
                    authorDao.selectByName(book.author.name).authorId
                }

        // Book
        val bookEntity = bookMapper.toBookEntity(book, authorId)
        bookDao.insert(bookEntity)

        //Sentence
        val insertedBookId = bookDao.selectBookIdByNameAndAuthorId(book.name, authorId)
        val sentenceEntities = sentenceMapper
                .toSentenceEntities(insertedBookId, book.sentences)
        sentenceDao.insert(sentenceEntities)
    }

    fun getBookInfos(): List<BookInfo> {
        val bookInfoEntities = bookDao.selectBookInfos()
        return bookMapper.toBookInfos(bookInfoEntities)
    }

    fun getSentencesBySentenceId(sentenceId: Long): Sentence {
        val sentenceSummaryEntity = sentenceDao.selectSentenceSummaryBySentenceId(sentenceId)
        return sentenceMapper.toSentence(sentenceSummaryEntity)
    }

}