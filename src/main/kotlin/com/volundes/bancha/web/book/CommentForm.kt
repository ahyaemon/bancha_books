package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.Comment
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CommentForm (
        val bookId: Long,

        val sentenceId: Long? = null,

        @get:NotBlank(message="{CommentForm.name.NotBlank}")
        @get:Size(max = 255, message="{CommentForm.name.Size}")
        val name: String,

        @get:NotBlank(message="{CommentForm.comment.NotBlank}")
        @get:Size(max = 255, message="{CommentForm.comment.Size}")
        val comment: String
){

    fun toComment() =  Comment(null, name, comment)

}