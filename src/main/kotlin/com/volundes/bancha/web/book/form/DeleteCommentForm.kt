package com.volundes.bancha.web.book.form

data class DeleteCommentForm(
        var bookId: Long,
        val sentenceId: Long,
        val commentId: Long,
        val deleteKey: String
)