package com.ll.exam.books_YonghoSong;




import com.ll.exam.books_YonghoSong.app.member.MemberRepository;
import com.ll.exam.books_YonghoSong.app.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")

public class MemberTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;


    @Test
    @DisplayName("기본정보 생성 완료")
    void t1(){


    }

    @Test
    @DisplayName("로그인 및 로그인 한 정보 가져오기")
    void t2(){


    }

}
