package com.galuszkat.shedlock

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class HelloWorldTask {

    @Scheduled(fixedDelay = 5_000)
    @SchedulerLock(
        name = "repeatHelloWorld", // unikalna nazwa, po której robiony jest lock
        lockAtLeastFor = "PT5s",  //  lock minimum na 5s, czyli task wykonuje się nie czesciej niz co 5s
        lockAtMostFor = "PT20s"    // jezeli node nie zakonczy taska po 20s lock jest zwalniany
    )
    fun repeatHelloWorld() {
        println("[${Thread.currentThread().name}] Hello world: ${Instant.now()}")

    }
}