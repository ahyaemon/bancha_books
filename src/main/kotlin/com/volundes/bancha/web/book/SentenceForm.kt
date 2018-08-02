package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.Sentence

data class SentenceForm(
        val sentenceId: Long?,
        val sentence: String,
        val commentItems: List<CommentItem>
) {

    constructor(sentence: Sentence): this(
            sentence.sentenceId,
            sentence.sentence,
            sentence.comments.map{ CommentItem(it) }
    )

    fun hasComment() = commentItems.isNotEmpty()

}