package com.volundes.bancha.web.book.session

import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component
import org.springframework.web.context.WebApplicationContext
import java.time.LocalDateTime

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
class SubmitInfoList{

    private val list  by lazy { mutableListOf<SubmitInfo>() }

    /**
     * ユーザーの投稿情報をlistに追加する。
     * id, sentenceIdがユニークにならない場合、
     * 旧情報を新情報で上書きする。
     */
    fun addNewInfo(bookId:Long, sentenceId: Long, submitDateTime: LocalDateTime) {
        val info = SubmitInfo(bookId, sentenceId, submitDateTime)
        list.add(info)
    }

    fun contains(bookId:Long, sentenceId: Long): Boolean {
        return list.any { it.bookId == bookId &&  it.sentenceId == sentenceId }
    }

    fun get(bookId: Long, sentenceId: Long): SubmitInfo {
        return list.first { it.bookId == bookId && it.sentenceId == sentenceId }
    }

}