package com.volundes.bancha.domain.paging

/**
 * ページング管理クラスです。
 * ページは 1 から始まります。
 */
class Page(
        // 現在のページ番号
        private val number: Int,

        // 画面表示の最大レコード数
        private val limit: Int,

        // 総レコード数
        private val total: Int,

        // ページング対象のURL
        private val url: String
) {
    private fun totalPage(): Int {
        val n = total / limit
        val s = total % limit
        return if(s == 0) { n } else { n + 1 }
    }

    fun offset() =  (number - 1) * limit
    fun limit() = limit

    fun isFirstPage() = number == 1
    fun isNotFirstPage() = !isFirstPage()

    fun hasPreviousPage() = number > 1
    fun notHasPreviousPage() = !hasPreviousPage()

    fun currentPageNumber() = number
    fun currentPageFirst() = (number - 1) * limit + 1
    fun currentPageLast(): Int{
        return if(number == totalPage()){
            total
        }
        else{
            number * limit
        }
    }

    fun total() = total

    fun hasNextPage() = (totalPage() - number) > 0
    fun notHasNextPage() = !hasNextPage()

    fun url() = url
    fun pageUrl(n: Int) = "$url?page=$n"
    fun firstPageUrl() = pageUrl(1)
    fun previousPageUrl() = pageUrl(number - 1)
    fun nextPageUrl() = pageUrl(number + 1)



}