package com.dhcc.cn.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ScheduleTaskConfig {

    @Scheduled(fixedDelay = 5000)
    public void task() {
//        log.info("1111");
    }
}
