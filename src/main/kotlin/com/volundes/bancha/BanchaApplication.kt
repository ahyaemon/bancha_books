package com.volundes.bancha

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BanchaApplication

fun main(args: Array<String>) {
    runApplication<BanchaApplication>(*args)
}
