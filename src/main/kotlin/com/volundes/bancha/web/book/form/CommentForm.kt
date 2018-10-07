package com.volundes.bancha.web.book.form

import com.volundes.bancha.domain.obj.book.Comment
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CommentForm (

        val bookId: Long,

        val sentenceId: Long? = null,

        @get:NotBlank(message="{CommentForm.comment.NotBlank}")
        @get:Size(max = 255, message="{CommentForm.comment.Size}")
        val comment: String

){

    fun toComment(accountId: Long): Comment {
        return Comment(null, accountId, "", comment)
    }

}