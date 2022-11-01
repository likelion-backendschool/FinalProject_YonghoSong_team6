package com.ll.exam.final__2022_10_08.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class RebateServiceTest {

    @Test
    @DisplayName("정산데이터를 생성한다")
    void t1() {

    }

    @Test
    @DisplayName("정산 데이터 전체를 조회한다.")
    void t2() {

    }

    @Test
    @DisplayName("정산한다 (전체)")
    void t3() {

    }

    @Test
    @DisplayName("정산한다 (건별)")
    void t4() {

    }
}
