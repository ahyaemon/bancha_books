package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.book.Book
import com.volundes.bancha.domain.book.Comment
import com.volundes.bancha.domain.book.CommentCountedBook
import com.volundes.bancha.domain.book.Sentence
import com.volundes.bancha.domain.bookmenu.BookMenu
import com.volundes.bancha.domain.paging.Page
import com.volundes.bancha.infra.dao.*
import com.volundes.bancha.infra.mapper.*
import org.springframework.stereotype.Repository

@Repository
class BookRepository(
        private val bookDao: BookDao,
        private val sentenceDao: SentenceDao,
        private val commentDao: CommentDao,
        private val authorDao: AuthorDao,
        private val deleteKeyDao: DeleteKeyDao
):
        Pageable,
        CommentMapperExtension,
        SentenceMapperExtension,
        BookMapperExtension,
        AuthorMapperExtension,
        DeleteKeyMapperExtension
{

    fun getBookMenus(page: Page): List<BookMenu>{
        return bookDao
                .selectBookMenu(page.toSelectOptions())
                .toBookMenus()
    }

    fun getCommentCountedBookByBookId(bookId: Long): CommentCountedBook {
        return bookDao
                .selectBookSummaryByBookId(bookId)
                .toCommentCountedBook()
    }

    fun insertComment(sentenceId: Long, comment: Comment) {
        // commentの登録
        val commentEntity = comment.toEntity(sentenceId)
        commentDao.insert(commentEntity)

        // deleteKeyの登録
        if(comment.canDelete()){
            val commentId = commentDao.selectId()
            val deleteEntity = comment.toDeleteKeyEntity(commentId)
            deleteKeyDao.insert(deleteEntity)
        }
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
                    authorEntityInDB.authorId
                }
                else{
                    // 一旦INSERTしたものを抜き出し、IDを得る
                    // TODO トランザクションレベルの考慮が必要
                    authorDao.selectByName(book.author.name).authorId
                }

        // Book
        val bookEntity = book.toBookEntity(authorId)
        bookDao.insert(bookEntity)

        //Sentence
        val insertedBookId = bookDao.selectBookIdByNameAndAuthorId(book.name, authorId)
        val sentenceEntities = book.sentences.toSentenceEntities(insertedBookId)
        sentenceDao.insert(sentenceEntities)
    }

    fun getSentencesBySentenceId(sentenceId: Long): Sentence {
        return sentenceDao
                .selectSentenceSummaryBySentenceId(sentenceId)
                .toSentence()
    }

    fun getDeleteKey(commentId: Long): String {
        return deleteKeyDao
                .selectByCommentId(commentId)
                .deleteKey
    }

    fun deleteComment(commentId: Long){
        // deleteKeyの削除
        val deleteTable = deleteKeyDao.selectByCommentId(commentId)
        deleteKeyDao.delete(deleteTable)

        // commentの削除
        val commentTable = commentDao.selectCommentByCommentId(commentId)
        commentDao.delete(commentTable)
    }

}