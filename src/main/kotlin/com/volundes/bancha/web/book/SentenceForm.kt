package com.volundes.bancha.web.book

import com.volundes.bancha.domain.book.Sentence

data class SentenceForm(
        var sentenceId: Long?,
        var sentence: String,
        var commentItems: List<CommentItem>,
        var rubyItems: List<RubyItem>
) {

    constructor(sentence: Sentence): this(
            sentence.sentenceId,
            sentence.sentence,
            sentence.comments.map{ CommentItem(it) },
            sentence.rubies.map{ RubyItem(it) }
    )

    fun hasComment(): Boolean{ return commentItems.size > 0 }

}