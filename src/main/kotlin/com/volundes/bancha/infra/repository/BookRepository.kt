package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.book.*
import com.volundes.bancha.domain.bookmenu.BookMenu
import com.volundes.bancha.domain.paging.Page
import com.volundes.bancha.infra.dao.*
import com.volundes.bancha.infra.mapper.*
import org.seasar.doma.jdbc.SelectOptions
import org.springframework.stereotype.Repository

@Repository
class BookRepository(
        private val bookDao: BookDao,
        private val sentenceDao: SentenceDao,
        private val commentDao: CommentDao,
        private val authorDao: AuthorDao,
        private val deleteKeyDao: DeleteKeyDao,
        private val bookMapper: BookInfraMapper,
        private val sentenceMapper: SentenceInfraMapper,
        private val authorMapper: AuthorInfraMapper,
        private val deleteKeyMapper: DeleteKeyInfraMapper
):
        Pageable,
        CommentMapperExtension
{

    fun getBookMenus(page: Page): List<BookMenu>{
        val selectOptions = page.toSelectOptions()
        val entities = bookDao.selectBookMenu(selectOptions)
        val bookMenus = entities.map{ bookMapper.toBookMenu(it) }
        return bookMenus
    }

    fun getCommentCountedBookByBookId(bookId: Long): CommentCountedBook {
        val bookSummaryEntity = bookDao.selectBookSummaryByBookId(bookId)
        val book = bookMapper.toCommentCountedBook(bookSummaryEntity)
        return book
    }

    fun insertComment(sentenceId: Long, comment: Comment) {
        // commentの登録
        val commentEntity = comment.toEntity(sentenceId)
        commentDao.insert(commentEntity);

        // deleteKeyの登録
        if(comment.canDelete()){
            val commentId = commentDao.selectId();
            val deleteEntity = deleteKeyMapper.toEntity(commentId, comment)
            deleteKeyDao.insert(deleteEntity)
        }
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

    fun getSentencesBySentenceId(sentenceId: Long): Sentence {
        val sentenceSummaryEntity = sentenceDao.selectSentenceSummaryBySentenceId(sentenceId)
        return sentenceMapper.toSentence(sentenceSummaryEntity)
    }

    fun getDeleteKey(commentId: Long): String {
        val entity = deleteKeyDao.selectByCommentId(commentId)
        return entity.deleteKey
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