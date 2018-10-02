package com.volundes.bancha.domain.service.bookmenu

import com.volundes.bancha.domain.`object`.bookmenu.BookMenu
import com.volundes.bancha.domain.page.Page
import com.volundes.bancha.infra.repository.BookRepository
import org.springframework.stereotype.Service

/**
 * 本メニューの管理を担うServiceです。
 */
@Service
class BookMenuService(
        private val repository: BookRepository
) {

    /**
     * @return すべての本メニュー
     */
    fun getBookMenus(page: Page): List<BookMenu> {
        return repository.getBookMenus(page)
    }

    fun getTotalBookAmount(): Int {
        return repository.getTotalBookAmount()
    }

}