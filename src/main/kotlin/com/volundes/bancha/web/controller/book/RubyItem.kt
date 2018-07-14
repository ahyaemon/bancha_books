package com.volundes.bancha.web.controller.book

import com.volundes.bancha.domain.dto.Ruby

data class RubyItem(
        val rubyId: Long,
        val kanji: String,
        val ruby: String
){

    constructor(ruby: Ruby): this(ruby.rubyId, ruby.kanji, ruby.ruby)

}