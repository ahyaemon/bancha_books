package com.volundes.bancha.domain.admin.download

class Dml(
        tableData: TableData
) {
    val dml: String
    val name: String
    val version: String

    init{
        name = tableData.name
        version = tableData.version

        val sb = StringBuilder()
        sb.append("INSERT INTO ${name}")
        sb.append("\r\n")

        sb.append("  (")
        sb.append(tableData.colNames.joinToString(", "))
        sb.append(")")
        sb.append("\r\n")

        sb.append("VALUES")
        sb.append("\r\n")

        sb.append(
            tableData.values.map{value ->
                "  (" + value.map{ "'$it'" }.joinToString(", ") + ")"
            }.joinToString(",\r\n")
        )
        sb.append(";\r\n")

        dml = sb.toString()
    }
}