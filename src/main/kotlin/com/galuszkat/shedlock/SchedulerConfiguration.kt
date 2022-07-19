package com.galuszkat.shedlock

import com.mongodb.client.MongoClient
import net.javacrumbs.shedlock.core.LockProvider
import net.javacrumbs.shedlock.provider.mongo.MongoLockProvider
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

private const val DB_NAME = "shedlock-db"

@Configuration
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "30s")
class SchedulerConfiguration {

    @Bean
    fun lockProvider(mongoClient: MongoClient): LockProvider {
        return MongoLockProvider(mongoClient.getDatabase(DB_NAME))
    }
}