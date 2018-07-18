package com.volundes.bancha.schedule

import org.quartz.*
import org.quartz.impl.StdSchedulerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.quartz.SchedulerFactoryBean

@Configuration
@Profile("production")
class SchedulerConfig(
        private val scheduler: Scheduler
) {

    @Autowired
    fun regularAccessSchedule() {
        val jobDetail: JobDetail = JobBuilder
                .newJob(RegularAccessJob::class.java)
                .withIdentity("testJob", "group1")
                .build()
        val trigger: Trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/20 * * * ?"))
                .build()
        scheduler.scheduleJob(jobDetail, trigger)
        scheduler.start()
    }
}
