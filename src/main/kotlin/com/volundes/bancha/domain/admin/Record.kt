package com.volundes.bancha.domain.admin

data class Record(
        val values: List<String>
){

    fun joinComma() = values.joinToString(",")
    fun joinCommaWithQuote() =  values.joinToString(","){ "'$it'" }

}