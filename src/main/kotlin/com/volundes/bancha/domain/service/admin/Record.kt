package com.volundes.bancha.domain.service.admin

data class Record(
        val values: List<String>
){

    fun joinComma() = values.reduce{ a, b -> "$a,$b" }
    fun joinCommaWithQuote() =  values.map{ "'$it'" }.reduce{ a, b -> "$a,$b" }

}