package com.volundes.bancha.web.book.session

import java.time.LocalDateTime

data class SubmitInfo(
        val bookId: Long,
        val sentenceId: Long,
        val submitDateTime: LocalDateTime
)