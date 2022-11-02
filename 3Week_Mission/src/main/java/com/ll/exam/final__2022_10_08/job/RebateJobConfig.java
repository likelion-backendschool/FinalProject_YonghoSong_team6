package com.ll.exam.final__2022_10_08.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RebateJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job rebateJob(){
        return jobBuilderFactory.get("rebateJob")
                .start(rebateStep1())
                .build();
    }

    @Bean
    public Step rebateStep1() {
        return stepBuilderFactory.get("rebateStep1")
                .tasklet(rebateTasklet())
                .build();
    }

    @Bean
    public Tasklet rebateTasklet() {
        return (contribution, chunkContext) -> {
            System.out.println("헬로월드!");

            return RepeatStatus.FINISHED;
        };
    }
}
