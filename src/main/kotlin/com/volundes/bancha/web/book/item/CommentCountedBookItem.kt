package com.volundes.bancha.web.book.item

import com.volundes.bancha.domain.book.CommentCountedBook

class CommentCountedBookItem(
        val bookId: Long?,
        val name: String,
        val author: String,
        val licenseItem: LicenseItem?,
        val sentenceItems: List<CommentCountedSentenceItem>
) {
    constructor(book: CommentCountedBook):
            this(
                    book.bookId,
                    book.name,
                    book.author.name,
                    if(book.license == null){
                        null
                    } else {
                        LicenseItem(book.license)
                    },
                    book.sentences.map{ CommentCountedSentenceItem(it) }
            )

    fun hasLicense(): Boolean {
        return licenseItem != null
    }

}