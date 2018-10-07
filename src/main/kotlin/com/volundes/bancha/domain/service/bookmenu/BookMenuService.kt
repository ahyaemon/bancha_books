package com.volundes.bancha.domain.service.bookmenu

import com.volundes.bancha.domain.obj.book.BookInfo
import com.volundes.bancha.domain.page.Page
import com.volundes.bancha.infra.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * 本メニューの管理を担うServiceです。
 */
@Service
@Transactional
class BookMenuService(
        private val repository: BookRepository
) {

    /**
     * @return すべての本メニュー
     */
    fun getBookInfos(page: Page): List<BookInfo> {
        return repository.getBookInfos(page)
    }

    fun getTotalBookAmount(): Int {
        return repository.getTotalBookAmount()
    }

}