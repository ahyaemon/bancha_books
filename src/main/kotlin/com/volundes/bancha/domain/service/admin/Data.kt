package com.volundes.bancha.domain.service.admin

data class Data(
        val name: String,
        private val titles: Record,
        private val records: List<Record>
) {

    fun toDml(): String{
        val header = titles.joinComma()
        val prefix = "INSERT $name ($header) VALUES"
        val values = records
                .joinToString(",\n"){ "(" + it.joinCommaWithQuote() + ")" }
        val dml = prefix + "\n" + values + ";\n"

        return dml
    }

    fun toCsv(): String{
        val header = titles.joinComma()
        val rows = records.joinToString("\n"){ it.joinComma() }
        val csv = header + "\n" + rows

        return csv
    }

}