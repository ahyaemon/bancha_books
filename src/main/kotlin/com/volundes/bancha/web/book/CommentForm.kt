package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.Comment
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CommentForm (
        var sentenceId: Long? = null,

        @get:NotBlank(message="名前が無い分け無いだろう")
        @get:Size(max = 255, message="名前長すぎない？")
        var name: String = "",

        @get:NotBlank(message="コメントが無い分け無いだろう")
        @get:Size(max = 255, message="コメント長すぎない？")
        var comment: String = ""
){

    fun toComment(): Comment { return Comment(null, name, comment)
    }

}