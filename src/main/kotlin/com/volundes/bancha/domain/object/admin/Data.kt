package com.volundes.bancha.domain.`object`.admin

/**
 * 複数のレコードを保持するデータ構造を表現するクラスです。
 *
 * @param[name] データ全体の名前
 * @param[titles] レコード内の個々の要素に対する名前
 * @param[records] 値を保持するレコードのリスト
 */
data class Data(
        val name: String,
        private val titles: Record,
        private val records: List<Record>
) {

    /**
     * sql形式のINSERT文を作成します。
     * レコードが無い場合、空文字列を返します。
     *
     * @return sql形式のINSERT文
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
     * CSV形式の文字列を作成します。
     * レコードが無い場合、ヘッダーのみのデータを返します。
     *
     * @return CSV形式の文字列
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