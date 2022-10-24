package com.ll.exam.books_YonghoSong.app.base;

import com.ll.exam.books_YonghoSong.app.member.Member;
import com.ll.exam.books_YonghoSong.app.member.MemberService;
import com.ll.exam.books_YonghoSong.app.member.dto.create.RequestCreateMember;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Profile("dev")
public class DevInitData {
    @Bean
    public CommandLineRunner initData(MemberService memberService /* , ProductService productService, CartService cartService */) {
        return args ->
        {
            String password = "{noop}inituser";
            //Member member1 = memberService.createMember(new RequestCreateMember("inituser1",password,"inituser1@gmail.com"));
            System.out.println("커맨드라인 러너 작동 완료");

        };
    }
}