package com.volundes.bancha.domain.service.admin.updatebook

import com.volundes.bancha.domain.obj.book.BookInfo
import com.volundes.bancha.domain.obj.book.CommentCountedBook
import com.volundes.bancha.domain.page.Page
import com.volundes.bancha.infra.repository.BookRepository
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
    fun getUpdateBookInfos(): List<BookInfo>{
        val page = Page(1, 10, 15, "/admin/book/update")
        return repository.getBookInfos(page)
    }

    /**
     * コメント数のカウント付きで本を取得します。
     *
     * @return コメント数のカウント付きの本
     */
    fun getCommentCountedBookByBookId(bookId: Long): CommentCountedBook {
        val page = Page(1, 10, 15, "/admin/book/update")
        return repository.getCommentCountedBookByBookId(bookId, page)
    }

}