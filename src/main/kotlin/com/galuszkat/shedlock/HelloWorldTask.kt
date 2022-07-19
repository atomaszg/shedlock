package com.galuszkat.shedlock

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class HelloWorldTask {

    @Scheduled(fixedDelay = 10_000)
    @SchedulerLock(name = "repeatHelloWorld")
    fun repeatHelloWorld() {
        println("Hello world: ${Instant.now()}")

    }
}