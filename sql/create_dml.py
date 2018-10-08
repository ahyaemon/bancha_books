#! coding: utf-8
import glob
import os.path
import codecs

newline = "\r\n"

def create_dml(tsv, table_name):
    dml = "CREATE TABLE " + table_name + newline
    dml += "(" + newline

    lines = tsv.replace("\r\n", "\n").split("\n")
    lines = lines[1:len(lines)]
    pk_name = ""
    for line in lines:
        if line == "":
            continue

        cells = line.split("\t")

        # name
        name = cells[0]
        dml += "    " + name

        # data type
        data_type = cells[2]
        dml += " " + data_type

        # unique
        is_unique = cells[3] == "y"
        if is_unique:
            dml += " UNIQUE"

        # not null
        is_not_null = cells[4] == "y"
        if is_not_null:
            dml += " NOT NULL"

        # primary key
        is_pk = cells[5] == "y"
        if is_pk:
            pk_name = name

        dml += "," + newline

    dml += "    PRIMARY KEY (" + pk_name + ")" + newline
    dml += ")" + newline
    return dml

if __name__ == "__main__":
    output_dir = "../src/main/resources/db/migration"

    target_dirs = glob.glob("table/*")
    for target_dir in target_dirs:
        # フォルダ名が「管理番号__テーブル名」となっているため、スプリットで抽出する
        dir_name = os.path.basename(target_dir)
        sp = dir_name.split("__")
        version = sp[0]
        table_name = sp[1]

        # dml を作成
        tsv_path = target_dir + "/dml.tsv"
        tsv = codecs.open(tsv_path, mode="r", encoding="UTF-8").read()
        dml = create_dml(tsv, table_name)

        # 保存
        output_path = output_dir + "/V" + version + ".1__create_" + table_name + ".sql"
        codecs.open(output_path, mode="w", encoding="UTF-8").write(dml)
