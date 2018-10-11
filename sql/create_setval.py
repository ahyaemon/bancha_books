#! coding: utf-8
import glob
import os.path
import codecs

newline = "\r\n"

if __name__ == "__main__":
    output_dir = "../src/main/resources/db/migration"

    target_dirs = glob.glob("table/*")
    table_names = [os.path.basename(x).split("__")[1] for x in target_dirs]
    setval_format = "select setval ('{table_name}_id_seq', 10000);"
    setval = newline.join([setval_format.format(table_name = x) for x in table_names])

    # 保存
    output_path = output_dir + "/V999.9__setval.sql"
    codecs.open(output_path, mode="w", encoding="UTF-8").write(setval)
