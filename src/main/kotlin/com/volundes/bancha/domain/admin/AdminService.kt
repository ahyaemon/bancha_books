package com.volundes.bancha.domain.admin

import com.volundes.bancha.infra.dao.UnrestoreDao
import com.volundes.bancha.env.init.flyway.RestoreTargetMapHolder
import org.seasar.doma.Column
import org.seasar.doma.Id
import org.seasar.doma.Table
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

/**
 * 管理用の処理を担うServiceです。
 */
/*
 *  Entityの操作をすることがあるため、Daoを直接呼び出す。
 */
@Service
class AdminService(
        private val applicationContext: ApplicationContext,
        private val restoreTargetMapHolder: RestoreTargetMapHolder,
        private val unrestoreDao: UnrestoreDao
) {

    private val unrestoreEntities by lazy { unrestoreDao.select() }

    /**
     * 復元用のデータを取得します。
     * 復元用データに初期投入データは含まれません。
     *
     * @return 復元用データのリスト
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

            // email
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
            @Suppress("UNCHECKED_CAST")
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