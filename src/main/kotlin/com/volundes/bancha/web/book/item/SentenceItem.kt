package com.volundes.bancha.web.book.item

import com.volundes.bancha.domain.`object`.book.Sentence

class SentenceItem(
        val sentenceId: Long?,
        val sentence: String,
        val commentItems: List<CommentItem>
){

    constructor(sentence: Sentence, accountId: Long):
            this(
                    sentence.id,
                    sentence.sentence,
                    sentence.comments.map{ CommentItem(it, accountId) }
            )

    fun hasComment() = commentItems.isNotEmpty()

}