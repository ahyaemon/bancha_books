package com.volundes.bancha.domain.repository

import com.volundes.bancha.domain.dto.*
import com.volundes.bancha.infra.dao.AuthorDao
import com.volundes.bancha.infra.dao.BookDao
import com.volundes.bancha.infra.dao.CommentDao
import com.volundes.bancha.infra.dao.SentenceDao
import com.volundes.bancha.infra.entity.CommentEntity
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

    fun getBookMenus() = bookDao.select().map{ bookMapper.toBookMenu(it)}

    fun getSentences(bookId: String): List<Sentence> {
        val summaries = sentenceDao.selectBookSummaryByBookId(Integer.parseInt(bookId))
        return sentenceMapper.toSentences(summaries)
    }

    fun getBookByBookId(bookId: String): Book {
        return bookMapper.toBook(bookDao.selectByBookId(Integer.parseInt(bookId)))
    }

    fun getBooks() = bookMapper.toBook(bookDao.select())

    fun insertComment(sentenceId: Long, comment: Comment) {
        val entity = commentMapper.toEntity(sentenceId, comment)
        commentDao.insert(entity)
    }

    fun getCommentsBySentenceId(sentenceId: Long): List<Comment> {
        val entities = sentenceDao.selectCommentBySentenceId(sentenceId)
        return sentenceMapper.toComment(entities)
    }

    fun getCommentEntities(): List<CommentEntity>{
        return commentDao.select()
    }

    fun addBook(insertBook: InsertBook){
        // InsertBook
        //   - AuthorEntity
        //   - InsertBookEntity TODO BookEntity になおす
        //   - SentenceEntity

        // Author
        val authorEntityInDB = authorDao.selectByName(insertBook.author)
        val authorExists = authorEntityInDB != null
        if(!authorExists){
            val authorEntity = authorMapper.toAuthorEntity(insertBook)
            authorDao.insert(authorEntity)
        }
        val authorId =
                if (authorExists) {
                    authorEntityInDB.authorId
                }
                else{
                    authorDao.selectByName(insertBook.author).authorId
                }

        // Book
        val insertBookEntity = bookMapper.toInsertBookEntity(insertBook, authorId)
        bookDao.insert(insertBookEntity)

        //Sentence
        val insertedBookId = bookDao.selectBookIdByNameAndAuthor(insertBook.name, insertBook.author)
        val sentenceEntities = sentenceMapper
                .toSentenceEntities(insertedBookId, insertBook.sentences)
        sentenceDao.insert(sentenceEntities)
    }

}