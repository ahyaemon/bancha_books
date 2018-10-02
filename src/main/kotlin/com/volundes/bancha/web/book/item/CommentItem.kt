package com.volundes.bancha.web.book.item

import com.volundes.bancha.domain.`object`.book.Comment

class CommentItem(
        val commentId: Long?,
        val name: String,
        val comment: String,
        val myComment: Boolean
){

    constructor(comment: Comment, accountId: Long):
            this(
                    comment.id,
                    comment.name,
                    comment.comment,
                   comment.accountId == accountId
            )

}