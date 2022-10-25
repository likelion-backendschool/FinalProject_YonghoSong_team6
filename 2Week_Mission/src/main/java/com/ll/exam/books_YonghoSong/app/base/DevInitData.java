package com.ll.exam.books_YonghoSong.app.base;

import com.ll.exam.books_YonghoSong.app.member.Member;
import com.ll.exam.books_YonghoSong.app.member.MemberService;
import com.ll.exam.books_YonghoSong.app.member.dto.create.RequestCreateMember;
import com.ll.exam.books_YonghoSong.app.member.dto.modify.RequestModifyMember;
import com.ll.exam.books_YonghoSong.app.product.ProductService;
import com.ll.exam.books_YonghoSong.app.product.cart.CartService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Profile("dev")
@Slf4j
public class DevInitData {
    private boolean initDataDone = false;
    @Bean
    public CommandLineRunner initData(MemberService memberService  , ProductService productService, CartService cartService ) {

        return args ->
        {

           /* if (initDataDone) return;
            initDataDone = true;

            String password = "{noop}inituser";
            //5명 유저 생성
            Map<Long,Member> memberMap = new HashMap<>();
            for(int i=1;i<=5;i++) {
                RequestCreateMember requestCreateMember = new RequestCreateMember("user"+i , password , "user%d@test.com".formatted(i));
                Member member = memberService.createMember(requestCreateMember);
                memberMap.put((long) i,member);
            }*/

            //1번 유저를 작가로 등록
           // RequestModifyMember requestModifyMember = new RequestModifyMember(1,"","author1","");
           // memberService.updateMember(requestModifyMember);

            //초기 돈

            //장바구니

            //주문
        };
    }
}