package com.volundes.bancha.domain.repository

import com.volundes.bancha.domain.dto.*
import com.volundes.bancha.infra.dao.BookDao
import com.volundes.bancha.infra.dao.CommentDao
import com.volundes.bancha.infra.dao.SentenceDao
import com.volundes.bancha.infra.mapper.BookInfraMapper
import com.volundes.bancha.infra.mapper.CommentInfraMapper
import com.volundes.bancha.infra.mapper.SentenceInfraMapper
import org.springframework.stereotype.Repository

@Repository
class BookRepository(
        private val bookDao: BookDao,
        private val sentenceDao: SentenceDao,
        private val commentDao: CommentDao,
        private val bookMapper: BookInfraMapper,
        private val sentenceMapper: SentenceInfraMapper,
        private val commentMapper: CommentInfraMapper
        ) {

    fun getBookMenus(): List<BookMenu>{
        return bookDao.select().map{ bookMapper.toBookMenu(it)}
    }

    fun getSentences(bookId: String): List<Sentence> {
        val summaries = sentenceDao.selectBookSummaryByBookId(Integer.parseInt(bookId))
        return sentenceMapper.toSentences(summaries)
    }

    fun getBookInfo(bookId: String): BookInfo {
        return bookMapper.toBookInfo(bookDao.selectByBookId(Integer.parseInt(bookId)))
    }

    fun insertComment(sentenceId: Long, comment: Comment) {
        val entity = commentMapper.toEntity(sentenceId, comment)
        commentDao.insert(entity)
    }

    fun getComments(sentenceId: Long): List<Comment> {
        val entities = sentenceDao.selectCommentBySentenceId(sentenceId)
        return sentenceMapper.toComment(entities)
    }

}