package com.volundes.bancha.web.controller.book

import com.volundes.bancha.domain.dto.Comment
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CommentForm (
        var sentenceId: Long? = null,

        @get:NotBlank
        @get:Size(max = 255)
        var name: String = "",

        @get:NotBlank
        @get:Size(max = 255)
        var comment: String = ""
){

    fun toComment(): Comment{ return Comment(null, name, comment) }

}