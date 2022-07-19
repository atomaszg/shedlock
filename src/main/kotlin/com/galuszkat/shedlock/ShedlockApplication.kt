package com.galuszkat.shedlock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.galuszkat.shedlock"])
class ShedlockApplication

fun main(args: Array<String>) {
	runApplication<ShedlockApplication>(*args)
}
