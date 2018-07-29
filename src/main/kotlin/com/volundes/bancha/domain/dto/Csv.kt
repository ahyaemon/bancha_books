package com.volundes.bancha.domain.dto

data class Csv(
        val name: String,
        val titles: List<String>,
        val rows: List<String>
) {

    fun toText(): String{
        return "a,b,c"
    }

}