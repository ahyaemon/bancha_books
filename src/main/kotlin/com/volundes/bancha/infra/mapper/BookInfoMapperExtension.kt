package com.volundes.bancha.infra.mapper

import com.volundes.bancha.domain.obj.book.*
import com.volundes.bancha.infra.entity.BookInfoEntity
import com.volundes.bancha.infra.entity.table.BookInfoTable

interface BookInfoMapperExtension {

    fun BookInfoEntity.toBookInfo(): BookInfo {
        val author = Author(authorId, authorName)
        val license = if (licenseId == null) {
            null
        } else {
            License(licenseId, licenseNotice, licenseType)
        }
        return BookInfo(bookInfoId, title, author, license)
    }

    fun List<BookInfoEntity>.toBookInfos() = map { it.toBookInfo() }

    fun BookInfo.toTable(): BookInfoTable {
        val table = BookInfoTable(id, title, author.id)
//        table.id = id
//        table.title = title
//        table.author_id = author.id
        return table
    }

}