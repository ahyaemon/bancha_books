package com.volundes.bancha.domain.admin.insertbook

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

/**
 * 青空文庫から取得したテキストファイルをパースし、
 * タイトル・著者・文を抽出します。
 */
class RawBookParser(
        rowBook: RawBook
) {

    private val document = Jsoup.parse(rowBook.content)
    private val rubyTags = arrayListOf("ruby", "rp", "rb", "rt")
    private val seps = arrayListOf("。』", "。」", "。")

    /**
     * titleクラスからタイトルを抽出して返します。
     *
     * @return 本のタイトル
     */
    fun getTitle(): String{
        return document.select(".title").text()
    }

    /**
     * authorクラスから著者を抽出して返します。
     *
     * @return 本の著者
     */
    fun getAuthor(): String{
        return document.select(".author").text()
    }

    /**
     * htmlタグを含む文字列をsepsで区切ってStringのリストに変換します。
     * rubyTagsに含まれるタグはそのまま残します。
     *
     * @return 文のリスト
     */
    fun getSentences(): List<String>{
        val rawHtml = document.select(".main_text").html()
        return rubyTags.fold(rawHtml){ html, tag -> html.encodeTag(tag) }
                .toDocument()
                .text()
                .splitSeps(seps)
                .map{ rubyTags.fold(it){ sentence, tag -> sentence.decodeTag(tag) } }
    }

    private fun String.toDocument(): Document {
        return Jsoup.parse(this)
    }

    private fun String.encodeTag(tag: String): String{
        return this.replace("<$tag>", "{$tag}").replace("</$tag>", "{/$tag}")
    }

    private fun String.decodeTag(tag: String): String{
        return this.replace("{$tag}", "<$tag>").replace("{/$tag}", "</$tag>")
    }

    private fun String.splitSeps(seps: List<String>): List<String>{
        val sepMarks = 0.until(seps.size).map { "__${it}__" }
        val replaced = seps.foldIndexed(this) { i, acc, sep ->
            acc.replace(sep, sepMarks[i])
        }

        val restored = sepMarks.foldIndexed(replaced) { i, acc, sepMark ->
            val li = acc.split(sepMark)
            val liWithSep = li.mapIndexed { j, value ->
                if (j < li.size - 1) value + seps[i] else value
            }
            liWithSep.joinToString("@")
        }

        val splitted = restored.split("@").filterNot{ it.isBlank() }
        return splitted
    }
}
