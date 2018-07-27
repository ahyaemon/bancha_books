package com.volundes.bancha.init.flyway

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import javax.sql.DataSource

@Configuration
@Profile("production")
class FlywayCleanConfig(
        private val dataSource: DataSource
) {

    @Autowired
    fun flywayClean(){
        val flyway = Flyway()
        flyway.setDataSource(dataSource)
        flyway.clean()
    }

}