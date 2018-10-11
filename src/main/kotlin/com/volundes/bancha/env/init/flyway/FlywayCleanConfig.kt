package com.volundes.bancha.env.init.flyway

import org.flywaydb.core.Flyway
import org.flywaydb.core.api.FlywayException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class FlywayCleanConfig(
        private val dataSource: DataSource
) {

    private val logger = LoggerFactory.getLogger(FlywayCleanConfig::class.java)

    /**
     * DBの初期化はここで行う（起動時の自動 Migration はやらない）
     * flywayのバージョンに変更があった場合のみ実行
     * ・clean
     * ・migrate
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
    }

    private fun Flyway.notUpdated():Boolean{
        try{
            validate()
        }
        catch(e: FlywayException){
            return false
        }
        return true
    }

}