package com.volundes.bancha.web.book.item

class CommentCountedSentenceItem(
        val sentenceId: Long?,
        val sentence: String,
        val heading: Int,
        val commentCount: Long
) {

    fun hasComment(): Boolean {
        return commentCount >= 1
    }

}