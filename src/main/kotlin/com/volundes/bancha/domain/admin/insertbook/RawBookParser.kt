package com.volundes.bancha.domain.admin.insertbook

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class RawBookParser(
        rowBook: RawBook
) {

    private val document = Jsoup.parse(rowBook.content)
    private val rubyTags = arrayListOf("ruby", "rp", "rb", "rt")
    private val seps = arrayListOf("。』", "。」", "。")

    fun getTitle(): String{
        return document.select(".title").text()
    }

    fun getAuthor(): String{
        return document.select(".author").text()
    }

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
