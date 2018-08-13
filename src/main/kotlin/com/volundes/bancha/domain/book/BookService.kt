package com.volundes.bancha.domain.book

import com.volundes.bancha.infra.repository.BookRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService(
        private val repository: BookRepository,
        private val passwordEncoder: PasswordEncoder
) {

    fun getCommentCountedBookByBookId(bookId: Long): CommentCountedBook {
        return repository.getCommentCountedBookByBookId(bookId)
    }

    /**
     * コメントを登録する。
     * 削除キーがある場合、暗号化して登録
     */
    fun createComment(sentenceId: Long, comment: Comment) {
        if(comment.hasDeleteKey){
            val encryptedDeleteKey = passwordEncoder.encode(comment.deleteKey)
            val newComment = comment.copy(deleteKey = encryptedDeleteKey)
            repository.insertComment(sentenceId, newComment)
        }
        else{
            repository.insertComment(sentenceId, comment)
        }
    }

    fun getSentenceBySentenceId(sentenceId: Long): Sentence {
        return repository.getSentencesBySentenceId(sentenceId)
    }

}