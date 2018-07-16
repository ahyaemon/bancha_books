package com.volundes.bancha.schedule

import org.quartz.*
import org.quartz.CronScheduleBuilder.*
import org.quartz.impl.StdSchedulerFactory

import org.springframework.stereotype.Component

@Component
class RegularAccessScheduler {
    constructor(){
        val jobDetail: JobDetail = JobBuilder
                .newJob(RegularAccessJob::class.java)
                .withIdentity("testJob", "group1")
                .build()
        val trigger: Trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(cronSchedule("0 0/20 * * * ?"))
                .build()

        val scheduler: Scheduler = StdSchedulerFactory.getDefaultScheduler()
        scheduler.start()
        scheduler.scheduleJob(jobDetail, trigger)
    }
}