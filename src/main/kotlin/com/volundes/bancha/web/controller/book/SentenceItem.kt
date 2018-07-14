package com.volundes.bancha.web.controller.book

import com.volundes.bancha.domain.dto.Sentence

data class SentenceItem(
        var sentenceId: Long,
        var sentence: String,
        val commentItems: List<CommentItem>,
        val rubyItems: List<RubyItem>
) {

    constructor(sentence: Sentence): this(
            sentence.sentenceId,
            sentence.sentence,
            sentence.comments.map{ CommentItem(it) },
            sentence.rubies.map{ RubyItem(it) }
    )

    fun hasComment(): Boolean{ return commentItems.size > 0 }

}