package com.volundes.bancha.domain.service.admin.maintenance.book.updatebook

import com.volundes.bancha.domain.obj.book.BookInfo
import com.volundes.bancha.domain.page.Page
import com.volundes.bancha.infra.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * 本の更新を担うServiceです。
 */
@Service
@Transactional
class UpdateBookService(
        private val repository: BookRepository
) {

    /**
     * 今ある本のリストを返します。
     *
     * @return 今ある本のリスト
     */
    fun getUpdateBookInfos(): List<BookInfo>{
        val page = Page(1, 10, 15, "/admin/book/update")
        return repository.findBookInfos(page)
    }

}