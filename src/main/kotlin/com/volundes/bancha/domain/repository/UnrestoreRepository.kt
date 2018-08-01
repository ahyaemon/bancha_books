package com.volundes.bancha.domain.repository

import com.volundes.bancha.infra.dao.UnrestoreDao
import com.volundes.bancha.infra.entity.UnrestoreEntity
import com.volundes.bancha.init.flyway.RestoreTargetMapHolder
import org.seasar.doma.Id
import org.seasar.doma.Table
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Repository

@Repository
class UnrestoreRepository(
        private val applicationContext: ApplicationContext,
        private val restoreTargetMapHolder: RestoreTargetMapHolder,
        private val unrestoreDao: UnrestoreDao
) {

    fun init() {
        val targets = restoreTargetMapHolder.getTargets()
        targets.forEach { daoClass, entityClass ->
            // name
            val annotation = entityClass.getAnnotation(Table::class.java) as Table
            val name = annotation.name

            // entities
            val dao = applicationContext.getBean(daoClass)
            val selectMethod = daoClass.getMethod("select")
            @Suppress("UNCHECKED_CAST")
            val entities = selectMethod(dao) as List<Any>

            // UnrestoreEntityを作成し、INSERTする
            val unrestoreEntities = entities.map { entity ->
                val unrestoreEntity = UnrestoreEntity()
                unrestoreEntity.tableName = name
                val idField = entityClass.fields.first { field ->
                    field.isAnnotationPresent(Id::class.java)
                }
                unrestoreEntity.id = idField.get(entity) as Long
                unrestoreEntity
            }
            unrestoreDao.insert(unrestoreEntities)
        }
    }

}