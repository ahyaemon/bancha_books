package com.volundes.bancha.domain.service.admin

import com.volundes.bancha.infra.dao.CommentDao
import com.volundes.bancha.infra.dao.DonationDao
import com.volundes.bancha.infra.dao.UnrestoreDao
import com.volundes.bancha.infra.entity.CommentEntity
import com.volundes.bancha.infra.entity.DonationEntity
import com.volundes.bancha.init.flyway.RestoreTargetMapHolder
import org.seasar.doma.Column
import org.seasar.doma.Id
import org.seasar.doma.Table
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

/*
Entityを操作するため、Daoを直接呼び出す
 */
@Service
class AdminService(
        private val applicationContext: ApplicationContext,
        private val restoreTargetMapHolder: RestoreTargetMapHolder,
        private val unrestoreDao: UnrestoreDao
) {

    private val unrestoreEntities by lazy { unrestoreDao.select() }

    /**
     * 復元用のデータを取得する
     * unrestoreDaoを使用し、初期投入データは除外する
     * Id列は除外する
     */
    fun getDataList(): List<Data>{
        val targets = restoreTargetMapHolder.getTargets()
        val dataList = targets.map{ entry ->
            val daoClass = entry.key
            val entityClass = entry.value
            val idField = entityClass.fields
                    .first{ it.isAnnotationPresent(Id::class.java)}
            val idRemovedFields = entityClass.fields
                    .filter{ !it.isAnnotationPresent(Id::class.java) }

            // name
            val tableAnnotation = entityClass.getAnnotation(Table::class.java)
            val name = tableAnnotation.name

            // titles
            // id列は外す
            val colnames = idRemovedFields.map{ field ->
                val columnAnnotation = field.getAnnotation(Column::class.java)
                columnAnnotation.name
            }
            val titles = Record(colnames)

            // records
            val removeIds = unrestoreEntities
                    .filter{ it.tableName == name }
                    .map{ it.id }
            val dao = applicationContext.getBean(daoClass)
            val selectMethod = daoClass.getMethod("select")
            val entities = selectMethod(dao) as List<Any>
            val records = entities
                    .filterNot{ entity ->
                        // unrestoreデータにあるIDと、entitiesのIDを突き合わせる
                        // 存在しないもののみをDataにつめる
                        val id = idField.get(entity) as Long
                        removeIds.contains(id)
                    }
                    .map{ entity ->
                        // ID列はDataに入れない
                        val values = idRemovedFields.map{ it.get(entity).toString() }
                        Record(values)
                    }

            // data
            Data(name, titles, records)
        }

        return dataList
    }

}