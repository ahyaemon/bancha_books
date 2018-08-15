package com.volundes.bancha.domain.bookmenu

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
    fun getBookMenus(): List<BookMenu> {
        return repository.getBookMenus()
    }

}