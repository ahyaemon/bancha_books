package com.volundes.bancha.domain.vo.admin.download

class TableData(
        val name: String,
        val version: String
) {

    var colNames: List<String> = listOf()
    val values: MutableList<List<String>> = mutableListOf()

    fun addValue(value: List<String>) {
        values.add(value)
    }

    fun toTsv(): String {
        // TODO 実装
        return "tsv"
    }

}