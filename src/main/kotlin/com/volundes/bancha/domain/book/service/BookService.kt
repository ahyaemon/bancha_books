package com.volundes.bancha.domain.book.service

import com.volundes.bancha.domain.book.Comment
import com.volundes.bancha.domain.book.CommentCountedBook
import com.volundes.bancha.domain.book.Sentence
import com.volundes.bancha.domain.paging.Page
import com.volundes.bancha.infra.repository.BookRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

/**
 * 本の管理を担うサービスです。
 */
@Service
class BookService(
        private val repository: BookRepository,
        private val passwordEncoder: PasswordEncoder
) {

    fun getCommentCountedBookByBookId(
            bookId: Long,
            page: Page
    ): CommentCountedBook {
        return repository.getCommentCountedBookByBookId(bookId, page)
    }

    /**
     * コメントを新規登録します。
     * コメントに削除キーが設定されている場合は、暗号化してから登録します。
     */
    fun createComment(
            sentenceId: Long,
            comment: Comment
    ) {
        if(comment.canDelete()){
            val encryptedDeleteKey = passwordEncoder.encode(comment.deleteKey)
            val newComment = comment.copy(deleteKey = encryptedDeleteKey)
            repository.insertComment(sentenceId, newComment)
        }
        else{
            repository.insertComment(sentenceId, comment)
        }
    }

    /**
     * sentenceIdから、文のリストを取得します。
     *
     * @return 文のリスト
     */
    fun getSentenceBySentenceId(sentenceId: Long): Sentence {
        return repository.getSentencesBySentenceId(sentenceId)
    }

    /**
     * deleteキーを検証し、コメントが削除可能かどうかを判断します。
     *
     * @return 削除可能な場合、true
     */
    fun canDeleteComment(commentId: Long, deleteKey: String): Boolean {
        val correctDeleteKey = repository.getDeleteKey(commentId)
        return passwordEncoder.matches(deleteKey, correctDeleteKey)
    }

    /**
     * コメントを削除します。
     */
    fun deleteComment(commentId: Long) {
        repository.deleteComment(commentId)
    }

    fun getTotalSentenceAmount(bookId: Long): Int {
        return repository.getTotalSentenceAmount(bookId)
    }

}