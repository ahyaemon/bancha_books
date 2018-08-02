package com.volundes.bancha.env.schedule

import org.quartz.Job
import org.quartz.JobExecutionContext
import java.net.HttpURLConnection
import java.net.URL

class RegularAccessJob : Job {
    override fun execute(context: JobExecutionContext){
        val url = URL("https://banchabooks.herokuapp.com/")
        val con = url.openConnection() as HttpURLConnection
        con.setRequestMethod("GET")
        con.connect()
        val statusCode = con.responseCode
        println("Scheduler: self access")
        println(statusCode)
    }
}