package com.volundes.bancha.web.admin.download

import com.volundes.bancha.domain.admin.download.DownloadService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletResponse

@Controller
@RequestMapping("/admin/download")
class DownloadController(
        private val service: DownloadService
) {

    /**
     * indexへのマッピングです。
     */
    @RequestMapping
    fun index(): String {
        return "admin/download/index"
    }

    /**
     * DMLをzipでダウンロードします。
     */
    @RequestMapping("/dml")
    fun downloadDml(
            response: HttpServletResponse
    ) {
        val dmls = service.getDmls()
        val zipper = Zipper(response, "dml.zip")
        dmls.forEach{ zipper.addFile(it.dml.toByteArray(), "${it.name}.sql") }
        zipper.close()
    }

    /**
     * tsvをzipでダウンロードします。
     */
    @RequestMapping("tsv")
    fun downloadTsv(
            response: HttpServletResponse
    ) {
        val tsvs = service.getTsvs()
        val zipper = Zipper(response, "dml.zip")
        tsvs.forEach{zipper.addFile(it.tsv.toByteArray(), "${it.name}.tsv")}
        zipper.close()
    }

}