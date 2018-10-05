package com.volundes.bancha.web.book.item

import com.volundes.bancha.domain.obj.book.Author
import com.volundes.bancha.domain.obj.book.Book
import com.volundes.bancha.domain.obj.book.CommentCountedBook

class CommentCountedBookItem(
        val bookId: Long?,
        val name: String,
        val author: String,
        val licenseItem: LicenseItem?,
        val sentenceItems: List<CommentCountedSentenceItem>
) {

    companion object {
        fun from(book: Book, commentCountedMap: Map<Long, Long>): CommentCountedBookItem {
            val bookInfo = book.bookInfo
            val author = bookInfo.author
            val licenseItem = if(book.bookInfo.license == null){
                null
            } else {
                LicenseItem(book.bookInfo.license)
            }
            val sentenceItems = book.sentences.map{
                val commentCount = commentCountedMap.get(it.id)
                CommentCountedSentenceItem(
                        it.id,
                        it.sentence,
                        it.heading,
                        commentCount ?: 0
                )
            }

            return CommentCountedBookItem(
                    book.id,
                    bookInfo.title,
                    author.name,
                    licenseItem,
                    sentenceItems
            )
        }
    }

    constructor(book: CommentCountedBook):
            this(
                    book.id,
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