package com.volundes.bancha.domain.service.admin

import com.volundes.bancha.infra.dao.CommentDao
import com.volundes.bancha.infra.dao.DonationDao
import com.volundes.bancha.infra.entity.CommentEntity
import com.volundes.bancha.infra.entity.DonationEntity
import org.seasar.doma.Table
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

/*
Entityを操作するため、Daoを直接呼び出す
 */
@Service
class AdminService(
        private val applicationContext: ApplicationContext
) {
    private val targets = mapOf(
            Pair(CommentDao::class.java, CommentEntity::class.java),
            Pair(DonationDao::class.java, DonationEntity::class.java)
    )

    fun getDataList(): List<Data>{
        val dataList = targets.map{ entry ->
            val daoClass = entry.key
            val entityClass = entry.value

            // name
            val annotation = entityClass.getAnnotation(Table::class.java) as Table
            val name = annotation.name

            // titles
            val titles = Record(entityClass.fields.map{ it.name })

            // records
            val dao = applicationContext.getBean(daoClass)
            val selectMethod = daoClass.getMethod("select")
            val entities = selectMethod(dao) as List<Any>
            val records = entities.map{ entity ->
                val values = entityClass.fields.map{ field ->
                    field.get(entity).toString()
                }
                Record(values)
            }

            // data
            Data(name, titles, records)
        }

        return dataList
    }
}