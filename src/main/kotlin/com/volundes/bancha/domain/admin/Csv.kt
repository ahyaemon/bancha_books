package com.volundes.bancha.domain.admin

data class Csv(
        val name: String,
        val titles: List<String>,
        val rows: List<String>
) {

    fun toText(): String{
        val header = titles.reduce{ a, b -> "$a,$b" }
        val content = rows.reduce{ a, b -> "$a\n$b" }
        val text = "$header\n$content"
        return text
    }

}