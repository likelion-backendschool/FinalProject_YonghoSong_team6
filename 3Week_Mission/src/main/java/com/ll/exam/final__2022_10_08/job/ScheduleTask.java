package com.ll.exam.final__2022_10_08.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// https://m.blog.naver.com/deeperain/221609802306

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduleTask {
    private final JobLauncher jobLauncher;
    private final MakeRebateOrderItemJobConfig makeRebateOrderItemJobConfig;
    private final RebateJobConfig rebateJobConfig;


    @Scheduled(cron = "0 0 0 15 * *") //매월 15일 자정에 실행
    public void rebateScheduledTask() {
        System.out.println("The current date (1) : " + LocalDateTime.now());
        JobExecution execution;
        try {
            // 스케줄러 매개변수 때문에 잡을 호출하는 법을 모르겠음
            // 이 부분에서 구현 중단
            //execution = jobLauncher.run(makeRebateOrderItemJobConfig.makeRebateOrderItemJob(/* step 매개변수 필요함. */), simpleJobParam());
        }
        catch (Exception e) {
            log.info("배치 오류 : 정산 데이터 생성 오류 발생");
        }
        try {
            execution = jobLauncher.run(rebateJobConfig.rebateJob(),simpleJobParam());
        }
        catch (Exception e){
            log.info("배치 오류 : 정산처리 오류 발생");
        }
    }


    private JobParameters simpleJobParam() {
        Map<String, JobParameter> confMap = new HashMap<>();
        confMap.put("time", new JobParameter(System.currentTimeMillis()));
        return new JobParameters(confMap);
    }
}