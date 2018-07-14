package com.volundes.bancha.web.controller.book

import com.volundes.bancha.domain.dto.Comment

data class CommentForm (
        var sentenceId: Long,
        var name: String,
        var comment: String
){

    fun toComment(): Comment{ return Comment(null, name, comment) }

}