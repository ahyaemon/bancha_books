package com.volundes.bancha.web.book.item

import com.volundes.bancha.domain.`object`.book.CommentCountedSentence

class CommentCountedSentenceItem(
        val sentenceId: Long?,
        val sentence: String,
        val heading: Int,
        val commentCount: Long
){

    constructor(sentence: CommentCountedSentence):
            this(sentence.id, sentence.sentence, sentence.heading, sentence.commentCount)

    fun hasComment() = commentCount > 0

}