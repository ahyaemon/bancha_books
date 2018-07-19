package com.volundes.bancha

import com.volundes.bancha.domain.dto.Subtitle
import com.volundes.bancha.domain.repository.SubtitleRepository
import com.volundes.bancha.infra.dao.SubtitleDao
import com.volundes.bancha.infra.mapper.SubtitleInfraMapper
import org.quartz.*
import org.quartz.impl.StdSchedulerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.quartz.SchedulerFactoryBean

@Configuration
class SubtitleConfiguration(
        private val scheduler: Scheduler
) {
    @Bean
    fun subtitleRepository(
        dao: SubtitleDao,
        mapper: SubtitleInfraMapper
    ): SubtitleRepository{
        val subtitles = mapper.toSubtitle(dao.select())
        return SubtitleRepository(subtitles)
    }

}
