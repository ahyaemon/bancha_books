package com.volundes.bancha.domain.`object`.admin

/**
 * 一行のレコードを表現するクラスです。
 * 要素のリストとしてvaluesを保持します。
 */
data class Record(
        val values: List<String>
){

    /**
     * @return valuesをカンマで区切った文字列
     */
    fun joinComma() = values.joinToString(",")

    /**
     * @return valuesをダブルクォートで囲み、カンマで区切った文字列
     */
    fun joinCommaWithQuote() =  values.joinToString(","){ "'$it'" }

}