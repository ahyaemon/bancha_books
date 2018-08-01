package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.Comment

class CommentItem(
        val commentId: Long?,
        val commentName: String,
        val comment: String
){

    constructor(comment: Comment): this(comment.commentId, comment.commentName, comment.comment)

}