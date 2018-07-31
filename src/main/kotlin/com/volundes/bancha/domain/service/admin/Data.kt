package com.volundes.bancha.domain.service.admin

data class Data(
        val name: String,
        private val titles: Record,
        private val records: List<Record>
) {

    /**
     * レコードが無い場合、空のデータを返す
     */
    fun toDml(): String{
        if(records.isEmpty()){
            return ""
        }

        val header = titles.joinComma()
        val prefix = "INSERT INTO $name\n  ($header) VALUES"
        val values = records
                .joinToString(",\n"){ "  (" + it.joinCommaWithQuote() + ")" }
        val dml = prefix + "\n" + values + "\n;\n"

        return dml
    }

    /**
     * レコードが無い場合、ヘッダーのみのデータを返す
     */
    fun toCsv(): String{
        val header = titles.joinComma()
        val csv = when(records.isEmpty()){
            true -> header + "\n"
            false -> {
                val rows = records.joinToString("\n"){ it.joinComma() }
                header + "\n" + rows + "\n"
            }
        }

        return csv
    }

}