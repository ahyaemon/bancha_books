#! coding: utf-8
import glob
import os.path
import codecs

newline = "\r\n"

def to_camel(s):
    sp = s.split("_")
    return sp[0] + _join_capitalize(sp[1:len(sp)])


def to_pascal(s):
    return _join_capitalize(s.split("_"))


def _join_capitalize(li):
    return "".join([x.capitalize() for x in li])


class Row:

    def __init__(self, line):
        sp = line.split("\t")
        self.column_name = sp[0]
        self.column_comment = sp[1]
        self.column_type = sp[2]
        self.is_unique = sp[3] == "y"
        self.is_not_null = sp[4] == "y"
        self.is_pk = sp[5] == "y"

        self.column_name_camel = to_camel(self.column_name)

        if self.column_type == "SERIAL":
            self.java_type_name = "Long"
        elif self.column_type == "INTEGER":
            self.java_type_name = "Integer"
        elif self.column_type == "BIGINT":
            self.java_type_name = "Long"
        elif self.column_type == "TEXT":
            self.java_type_name = "String"
        elif self.column_type == "TIMESTAMP":
            self.java_type_name = "LocalDateTime"
        else:
            self.java_type_name = "Object"


def create_table(tsv, table_name):
    class_name = to_pascal(table_name) + "Table"
    lines = tsv.replace("\r\n", "\n").split("\n")
    lines = lines[1:len(lines)]
    rows = [Row(line) for line in lines if line != ""]

    table = "package com.volundes.bancha.infra.entity.table;" + newline
    table += newline
    table += "import org.seasar.doma.*;" + newline
    table += newline
    if "TIMESTAMP" in tsv:
        table += "import java.time.LocalDateTime;" + newline
        table += newline
    table += "@Entity(immutable = true)" + newline
    table += "@Table(name = \"{table_name}\")".format(table_name = table_name) + newline
    table += "public class {class_name} {{".format(class_name = class_name) + newline
    table += newline

    # メンバフィールドの作成
    for row in rows:
        # table += "    // {column_comment}".format(column_comment = row.column_comment) + newline

        # primary key の場合は、自動連番の設定を付与する
        if row.is_pk:
            table += "    @Id" + newline
            table += "    @GeneratedValue(strategy = GenerationType.IDENTITY)" + newline

        # @Column アノテーションの付与
        table += "    @Column(name = \"{column_name}\")".format(column_name = row.column_name) + newline

        # フィールド宣言の作成
        table += "    final public {java_type_name} {column_name_camel};".format(
                java_type_name = row.java_type_name,column_name_camel = row.column_name_camel)
        table += newline
        table += newline

    # コンストラクタの作成
    arguments = ", ".join([row.java_type_name + " " + row.column_name_camel for row in rows])
    table += "    public {class_name}({arguments}) {{".format(
        class_name = class_name, arguments = arguments)
    table += newline

    for row in rows:
        table += "        this.{column_name_camel} = {column_name_camel};".format(
            column_name_camel = row.column_name_camel)
        table += newline

    table += "    }" + newline
    table += newline

    table += "}"
    table += newline
    return table


if __name__ == "__main__":
    output_dir = "../src/main/java/com/volundes/bancha/infra/entity/table"

    target_dirs = glob.glob("table/*")
    for target_dir in target_dirs:
        # フォルダ名が「管理番号__テーブル名」となっているため、スプリットで抽出する
        dir_name = os.path.basename(target_dir)
        sp = dir_name.split("__")
        version = sp[0]
        table_name = sp[1]

        # table_class を作成
        tsv_path = target_dir + "/dml.tsv"
        tsv = codecs.open(tsv_path, mode="r", encoding="UTF-8").read()
        table = create_table(tsv, table_name)

        # 保存
        output_path = output_dir + "/" + to_pascal(table_name) + "Table.java"
        codecs.open(output_path, mode="w", encoding="UTF-8").write(table)
