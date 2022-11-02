package com.ll.exam.final__2022_10_08.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// https://m.blog.naver.com/deeperain/221609802306

@Component
public class ScheduleTask {

    @Scheduled(cron = "0 0 0 15 * *")
    public void rebateScheduledTask() {
        System.out.println("The current date (1) : " + LocalDateTime.now());

    }

//    @Scheduled(fixedDelayString = "${spring.task.fixedDelay}")
//    public void task2() {
//        System.out.println("The current date (2) : " + LocalDateTime.now());
//    }
}