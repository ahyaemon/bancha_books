package com.volundes.bancha.env.init.flyway

import com.volundes.bancha.infra.repository.RestoreRepository
import com.volundes.bancha.infra.repository.UnrestoreRepository
import com.volundes.bancha.infra.dao.CommentDao
import org.flywaydb.core.Flyway
import org.flywaydb.core.api.FlywayException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import javax.sql.DataSource

@Configuration
class FlywayCleanConfig(
        private val dataSource: DataSource,
        private val unrestoreRepository: UnrestoreRepository,
        private val restoreRepository: RestoreRepository
) {

    private val logger = LoggerFactory.getLogger(FlywayCleanConfig::class.java)

    /**
     * DBの初期化はここで行う（起動時の自動 Migration はやらない）
     * flywayのバージョンに変更があった場合のみ実行
     * ・clean
     * ・migrate
     * ・unrestoreテーブルの初期化
     * TODO ここでunrestoreRepositoryが正しく使えるか確認
     * TODO ApplicationContextの初期化が終わっていない可能性がある
     */
    @Autowired
    fun initDB(){
        val flyway = Flyway()
        flyway.dataSource = dataSource

        if(flyway.notUpdated()){
            logger.info("Skipping flyway clean and migration.")
            return
        }

        flyway.clean()
        flyway.migrate()

        try{
            unrestoreRepository.init()
            logger.info("Creating unrestore data success.")
        }
        catch(e: Exception){
            logger.warn("Failed to create unrestore data.", e)
        }

        try{
            restoreRepository.restore()
            logger.info("Restore data success.")
        }
        catch(e: Exception){
            logger.warn("Failed to restore data.", e)
        }
    }

    fun Flyway.notUpdated():Boolean{
        try{
            validate()
        }
        catch(e: FlywayException){
            return false
        }
        return true
    }

}