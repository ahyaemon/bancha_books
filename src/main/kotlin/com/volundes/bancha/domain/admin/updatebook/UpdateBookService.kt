package com.volundes.bancha.domain.admin.updatebook

import com.volundes.bancha.domain.book.CommentCountedBook
import com.volundes.bancha.domain.bookmenu.BookMenu
import com.volundes.bancha.domain.paging.Page
import com.volundes.bancha.infra.repository.BookRepository
import org.seasar.doma.jdbc.SelectOptions
import org.springframework.stereotype.Service

/**
 * 本の更新を担うServiceです。
 */
@Service
class UpdateBookService(
        private val repository: BookRepository
) {

    /**
     * 今ある本のリストを返します。
     *
     * @return 今ある本のリスト
     */
    fun getUpdateBookMenus(): List<BookMenu>{
        val page =  Page(1, 10, 15, "/admin/book/update")
        return repository.getBookMenus(page)
    }

    /**
     * コメント数のカウント付きで本を取得します。
     *
     * @return コメント数のカウント付きの本
     */
    fun getCommentCountedBookByBookId(bookId: Long): CommentCountedBook {
        return repository.getCommentCountedBookByBookId(bookId)
    }

}