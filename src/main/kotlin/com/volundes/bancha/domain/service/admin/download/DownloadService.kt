package com.volundes.bancha.domain.service.admin.download

import com.volundes.bancha.domain.vo.admin.download.Dml
import com.volundes.bancha.domain.vo.admin.download.TableData
import com.volundes.bancha.domain.vo.admin.download.TableInfo
import com.volundes.bancha.domain.vo.admin.download.Tsv
import com.volundes.bancha.infra.repository.TableInfoRepository
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DownloadService(
        private val context: ApplicationContext,
        private val tableInfoRepository: TableInfoRepository
) {

    fun getDmls(): List<Dml> {
        val tableInfos = tableInfoRepository.findTableInfo()
        val rowDataList = getRowDataList(tableInfos)
        val dmls = rowDataList.map{ Dml(it) }
        return dmls
    }

    fun getTsvs(): List<Tsv> {
        val tableInfos = tableInfoRepository.findTableInfo()
        val rowDataList = getRowDataList(tableInfos)
        val tsvs = rowDataList.map{ Tsv(it) }
        return tsvs
    }

    private fun getRowDataList(tableInfos: List<TableInfo>): List<TableData> {
        return tableInfos.mapNotNull{
            try{
                getRowData(it)
            } catch(e: Exception) {
                null
            }
        }
    }

    // RowData側に持たせるか？
    private fun getRowData(tableInfo: TableInfo): TableData? {
        val dao = context.getBean("${tableInfo.name}DaoImpl")
        val cls = dao.javaClass

        val method = try{
            cls.getDeclaredMethod("select")
        } catch(e: NoSuchMethodException) {
            println(e.message)
            println("${tableInfo.name} has no method named select")
            return null
        }

        val records = method.invoke(dao) as ArrayList<Any>
        if(records.isEmpty()) {
            return null
        }
        val firstRecord = records.first()
        val recordCls = firstRecord.javaClass
        val fields = recordCls.declaredFields
        val colNames = fields.map{ it.name }
        val rowData = TableData(tableInfo.name, tableInfo.version)
        rowData.colNames = colNames
        records.forEach{ record ->
            val value = fields.map{ it.get(record).toString() }
            rowData.addValue(value)
        }
        return rowData
    }

}