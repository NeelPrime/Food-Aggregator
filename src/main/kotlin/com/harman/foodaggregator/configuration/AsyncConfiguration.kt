package com.harman.foodaggregator.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor


/**
 * Configuration class of Asynchronous
 */
@Configuration
@EnableAsync
class AsyncConfiguration {

    /**
     * It returns ThreadPoolTaskExecutor to run thread parallel
     *
     */
    @Bean
    fun asyncExecutor():Executor {
        val executor=ThreadPoolTaskExecutor()
        executor.maxPoolSize=10

        return executor

    }
}