package com.volundes.bancha.domain.paging

/**
 * ページング管理クラスです。
 * ページは 1 から始まります。
 */
class Page(
        private val number: Int,
        private val limit: Int
) {

    fun getOffset(): Int{
        return number * limit
    }

    fun getLimit(): Int{
        return limit
    }

}