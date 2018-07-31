package com.volundes.bancha.web.controller.admin

import com.volundes.bancha.domain.service.admin.AdminService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import java.io.BufferedOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import javax.servlet.http.HttpServletResponse

@Controller
@RequestMapping("/admin")
class AdminController(
        private val service: AdminService
) {

    @RequestMapping("/login")
    fun login(): String {
        return "admin/login"
    }

    @RequestMapping("/menu")
    fun menu(): String {
        return "admin/menu"
    }

    @RequestMapping("/download/dml")
    fun downloadRestoreDml(): ResponseEntity<ByteArray>{
        val headers = HttpHeaders()
        headers.add("Content-Type", "text/csv; charset=UTF-8")
        headers.setContentDispositionFormData("filename", "restore.script")

        val dataList = service.getDataList()
        val dml = dataList.map{ it.toDml() }.reduce{ a, b -> "$a\n$b"}
        return ResponseEntity(dml.toByteArray(), headers, HttpStatus.OK)
    }

    @RequestMapping("/download/csv")
    fun downloadRestoreCsv(
            response: HttpServletResponse
    ) {
        // zipダウンロード用の情報をresponseにセット
        response.contentType = "application/octet-stream;charset=UTF-8"
        response.setHeader("Content-Disposition", "attachment; filename=restore.zip")
        response.setHeader("Content-Transfer-Encoding", "binary")

        val os = response.outputStream
        val bos = BufferedOutputStream(os)
        val zos = ZipOutputStream(bos)
        val dataList = service.getDataList()
        dataList.forEach {
            val ze = ZipEntry("${it.name}.csv")
            zos.putNextEntry(ze)
            zos.write(it.toCsv().toByteArray())
            zos.closeEntry()
        }
        zos.close()
    }

}