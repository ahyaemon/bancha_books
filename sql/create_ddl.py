#! coding: utf-8
import glob
import os.path
import codecs

newline = "\r\n"

def create_ddl(tsv, table_name):
    ddl = "CREATE TABLE " + table_name + newline
    ddl += "(" + newline

    lines = tsv.replace("\r\n", "\n").split("\n")
    lines = lines[1:len(lines)]
    pk_name = ""
    for line in lines:
        if line == "":
            continue

        cells = line.split("\t")

        # name
        name = cells[0]
        ddl += "    " + name

        # data type
        data_type = cells[2]
        ddl += " " + data_type

        # unique
        is_unique = cells[3] == "y"
        if is_unique:
            ddl += " UNIQUE"

        # not null
        is_not_null = cells[4] == "y"
        if is_not_null:
            ddl += " NOT NULL"

        # primary key
        is_pk = cells[5] == "y"
        if is_pk:
            pk_name = name

        ddl += "," + newline

    ddl += "    PRIMARY KEY (" + pk_name + ")" + newline
    ddl += ")" + newline
    return ddl

if __name__ == "__main__":
    output_dir = "../src/main/resources/db/migration"

    target_dirs = glob.glob("table/*")
    for target_dir in target_dirs:
        # フォルダ名が「管理番号__テーブル名」となっているため、スプリットで抽出する
        dir_name = os.path.basename(target_dir)
        sp = dir_name.split("__")
        version = sp[0]
        table_name = sp[1]

        # ddl を作成
        tsv_path = target_dir + "/ddl.tsv"
        tsv = codecs.open(tsv_path, mode="r", encoding="UTF-8").read()
        ddl = create_ddl(tsv, table_name)

        # 保存
        output_path = output_dir + "/V" + version + ".1__create_" + table_name + ".sql"
        codecs.open(output_path, mode="w", encoding="UTF-8").write(ddl)
