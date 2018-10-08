#! coding: utf-8
import glob
import os.path
import codecs

newline = "\r\n"

def create_ddl(tsv, table_name):
    lines = tsv.replace("\r\n", "\n").split("\n")
    header = lines[0]
    records = lines[1:len(lines)]

    ddl = "INSERT INTO " + table_name + newline
    ddl += "    (" + header.replace("\t", ", ") + ")" + newline
    ddl += "VALUES" + newline

    # 1列目は id なので、連番でふる
    first_id = int(records[0].split("\t")[0])
    for (irecord, record) in enumerate(records):
        if record == "":
            continue

        id = first_id + irecord
        cells = record.split("\t")
        ddl += "    ("
        for (icell, cell) in enumerate(cells):
            if icell == 0:
                ddl += "'" + str(id) + "'"
            else:
                ddl += "'" + cell + "'"

            if icell < len(cells) - 1:
                ddl += ", "
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
        # 元ファイルが複数ある場合がある（dml.tsv, dml_2.tsv...）
        target_files = glob.glob(target_dir + "/ddl*.tsv")
        for target_file in target_files:
            # ファイル名が「ddl_n.tsv」となっている場合がある
            file_name = os.path.basename(target_file)
            sp_file = file_name.split(".")[0].split("_")

            tsv = codecs.open(target_file, mode="r", encoding="UTF-8").read()
            ddl = create_ddl(tsv, table_name)

            # 保存
            if len(sp_file) == 1:
                # n がない場合
                output_path = output_dir + "/V" + version + ".2__insert_" + table_name + ".sql"
            else:
                # nがある場合
                output_path = output_dir + "/V" + version + ".2." + sp_file[1] + "__insert_" + table_name + ".sql"
            codecs.open(output_path, mode="w", encoding="UTF-8").write(ddl)
