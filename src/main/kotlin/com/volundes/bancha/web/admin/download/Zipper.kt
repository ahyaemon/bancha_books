package com.volundes.bancha.web.admin.download

import java.io.BufferedOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import javax.servlet.http.HttpServletResponse

/**
 * response を保持し、ファイルをzipに固めます
 */
class Zipper(
        response: HttpServletResponse,
        zipname: String
) {

    var zos: ZipOutputStream
    init {
        response.contentType = "application/octet-stream;charset=UTF-8"
        response.setHeader("Content-Disposition", "attachment; zipname=$zipname")
        response.setHeader("Content-Transfer-Encoding", "binary")

        val os = response.outputStream
        val bos = BufferedOutputStream(os)
        zos = ZipOutputStream(bos)
    }

    fun addFile(content: ByteArray, filename: String) {
        val ze = ZipEntry("$filename")
        zos.putNextEntry(ze)
        zos.write(content)
        zos.closeEntry()
    }

    fun close() {
        zos.close()
    }

}