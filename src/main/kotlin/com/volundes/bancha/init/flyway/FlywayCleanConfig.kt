package com.volundes.bancha.init.flyway

import org.flywaydb.core.Flyway
import org.flywaydb.core.api.FlywayException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import javax.sql.DataSource

@Configuration
class FlywayCleanConfig(
        private val dataSource: DataSource
) {

    @Autowired
    fun flywayClean(){
        val flyway = Flyway()
        flyway.dataSource = dataSource

        // バージョンが違う場合、cleanする
        try{
            flyway.validate()
        }
        catch(e: FlywayException){
            flyway.clean() // TODO ログに出す
        }
    }

}