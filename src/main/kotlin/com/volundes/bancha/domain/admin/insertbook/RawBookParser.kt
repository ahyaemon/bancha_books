package com.volundes.bancha.domain.admin.insertbook

import org.jsoup.Jsoup
import org.jsoup.select.Elements

class RawBookParser(
        rowBook: RawBook
) {

    private val document = Jsoup.parse(rowBook.content)
    private val rubyTags = arrayListOf("ruby", "rp", "rb", "rt")
    private val seps = arrayListOf("。』", "。」", "。") // TODO これで区切るようにする

    fun getTitle(): String{
        return getElements(".title").text()
    }

    fun getAuthor(): String{
        return getElements(".author").text()
    }

    fun getSentences(): List<String>{
        val rawHtmlText = getElements(".main_text").html()
        val replacedHtmlText = rubyTags.fold(rawHtmlText){
            html, tag -> html
                .replace("<$tag>", "{$tag}")
                .replace("</$tag>", "{/$tag}")
        }
        val replacedDocument = Jsoup.parse(replacedHtmlText)
        val replacedSentences = replacedDocument.text().split("。").map{ "$it。" }
        val sentences = replacedSentences.map{
            rubyTags.fold(it){
                sentence, tag -> sentence
                    .replace("{$tag}", "<$tag>")
                    .replace("{/$tag}", "</$tag>")
            }
        }

        return sentences
    }

    private fun getElements(selector: String): Elements{
        return document.select(selector)
    }

}