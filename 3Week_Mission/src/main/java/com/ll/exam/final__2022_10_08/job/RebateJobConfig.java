package com.ll.exam.final__2022_10_08.job;

import com.ll.exam.final__2022_10_08.app.rebate.entity.RebateOrderItem;
import com.ll.exam.final__2022_10_08.app.rebate.repository.RebateOrderItemRepository;
import com.ll.exam.final__2022_10_08.app.rebate.service.RebateService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class RebateJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final RebateOrderItemRepository rebateOrderItemRepository;
    private final RebateService rebateService;

    @Bean
    public Job rebateJob(){
        return jobBuilderFactory.get("rebateJob")
                .incrementer(new RunIdIncrementer()) // 강제로 매번 다른 ID를 실행시에 파라미터로 부여
                .start(rebateStep1())
                .build();
    }

    @Bean
    @JobScope
    public Step rebateStep1() {
        return stepBuilderFactory.get("rebateStep1")
                .tasklet(rebateTasklet())
                .build();
    }

    @Bean
    @StepScope
    public Tasklet rebateTasklet() {
        return (contribution, chunkContext) -> {
            System.out.println("정산 배치 실행됨!");
            List<RebateOrderItem> rebateOrderItems = rebateOrderItemRepository.findAll();
            rebateOrderItems.stream()
                    .forEach(
                            (rebateOrderItem)->{
                                rebateService.rebate(rebateOrderItem.getOrderItem().getId());
                        }
                    );
            return RepeatStatus.FINISHED;
        };
    }
}
