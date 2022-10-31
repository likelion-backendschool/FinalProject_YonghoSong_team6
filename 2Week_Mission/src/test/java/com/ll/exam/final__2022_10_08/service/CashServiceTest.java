package com.ll.exam.final__2022_10_08.service;

import com.ll.exam.final__2022_10_08.app.cash.service.CashService;
import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import com.ll.exam.final__2022_10_08.app.member.repository.MemberRepository;
import com.ll.exam.final__2022_10_08.app.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class CashServiceTest {
    @Autowired
    private CashService cashService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;


    @Test
    @DisplayName("회원에게 예치금을 추가한다.")
    void t1(){
        Member member = memberRepository.findById(1L).get();
        memberService.addCash(member,100000L,"예치금 충전");
        long balance = memberService.addCash(member,300000L,"예치금 충전");

        assertThat(balance).isEqualTo(400000L);
        assertThat(member.getRestCash()).isEqualTo(400000L);
    }

    @Test
    @DisplayName("예치금으로 결제한다. (기존 addCash 이용)")
    void t2(){
        Member member = memberRepository.findById(1L).get();
        memberService.addCash(member,100000L,"예치금 충전");
        memberService.addCash(member,-10000L,"예치금 사용");

        assertThat(member.getRestCash()).isEqualTo(90000L);
    }

    @Test
    @DisplayName("예치금이 부족시 예외를 발생한다. (새 메소드 subCash 사용)")
    void t3(){
        Member member = memberRepository.findById(1L).get();
        memberService.addCash(member,100000L,"예치금 충전");

        assertThatThrownBy(() ->
                memberService.subCash(member,110000L,"예치금 충전")
                ).isInstanceOf(RuntimeException.class);
    }
}
