package com.volundes.bancha.domain.service.admin

import com.volundes.bancha.domain.dto.Csv
import org.springframework.stereotype.Service

@Service
class AdminService(
) {

    fun getDml(): String{
        return "test dml content"
    }

    fun getCsvs(): List<Csv>{
        return arrayListOf(
                Csv("test1", arrayListOf("titles"), arrayListOf("rows")),
                Csv("test2", arrayListOf("titles"), arrayListOf("rows"))
        )
    }

}