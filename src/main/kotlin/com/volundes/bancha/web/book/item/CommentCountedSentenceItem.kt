package com.volundes.bancha.web.book.item

import com.volundes.bancha.domain.book.CommentCountedSentence

class CommentCountedSentenceItem(
        val sentenceId: Long?,
        val sentence: String,
        val heading: Int,
        val commentCount: Long
){

    constructor(sentence: CommentCountedSentence):
            this(sentence.sentenceId, sentence.sentence, sentence.heading, sentence.commentCount)

    fun hasComment() = commentCount > 0

}