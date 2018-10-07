package com.volundes.bancha.web.book.item

import com.volundes.bancha.domain.obj.book.Book

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

    fun hasLicense(): Boolean {
        return licenseItem != null
    }

}