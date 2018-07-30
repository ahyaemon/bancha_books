package com.volundes.bancha.domain.service.admin

data class Data(
        val name: String,
        val titles: Record,
        val records: List<Record>
) {

    fun toDml(): String{
        val prefix = "INSERT comment (" + titles.joinComma() + ") VALUES"
        val values = records
                .map{ "(" + it.joinCommaWithQuote() + ")" }
                .reduce{ a, b -> a + ",\n" + b}
        val dml = prefix + "\n" + values + ";\n"
        return dml
    }

    fun toCsv(): String{
        val header = titles.joinComma()
        val rows = records
                .map{ it.joinComma() }
                .reduce{ a, b -> a + "\n" + b}
        val csv = header + "\n" + rows
        return csv
    }

}