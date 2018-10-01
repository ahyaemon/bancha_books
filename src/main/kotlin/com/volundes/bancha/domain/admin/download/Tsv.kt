package com.volundes.bancha.domain.admin.download

class Tsv(
        tableData: TableData
) {
    var tsv: String
    var name: String
    var version: String

    init{
        name = tableData.name
        version = tableData.version

        val sb = StringBuilder()
        sb.append(version)
        sb.append("\r\n")

        sb.append(tableData.colNames.joinToString("\t"))
        sb.append("\r\n")

        sb.append(
            tableData.values.map{value ->
                value.joinToString("\t")
            }.joinToString("\r\n")
        )

        tsv = sb.toString()
    }
}