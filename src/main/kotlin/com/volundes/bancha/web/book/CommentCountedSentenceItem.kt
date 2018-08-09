package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.CommentCountedSentence

class CommentCountedSentenceItem(
        val sentenceId: Long?,
        val sentence: String,
        val commentCount: Long
){

    constructor(sentence: CommentCountedSentence):
            this(sentence.sentenceId, sentence.sentence, sentence.commentCount)

    fun hasComment() = commentCount > 0

}