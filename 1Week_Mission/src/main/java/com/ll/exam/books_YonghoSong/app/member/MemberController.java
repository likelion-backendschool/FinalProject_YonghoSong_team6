package com.ll.exam.books_YonghoSong.app.member;


import com.ll.exam.books_YonghoSong.app.member.dto.RequestCreateMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/join")
    void joinPage(){}

    @PostMapping("/member/join")
    long join(@RequestBody RequestCreateMember requestCreateMember){
        /*
        * http://localhost:8084/member/join
        * */

        long id = memberService.createMember(requestCreateMember);
        return id;
    }

    @GetMapping("/member/login")
    void loginPage(){}

    @PostMapping("/member/login")
    void login(){}

    @GetMapping("/member/logout")
    void logout(){}

    @GetMapping("/member/modify")
    void modifyPage(){}

    @PostMapping("/member/modify")
    void modify(){}

    @GetMapping("/member/modifyPassword")
    void modifyPasswordPage(){}

    @PostMapping("/member/modifyPassword")
    void modifyPassword(){}

    @GetMapping("/member/findUsername")
    void findUsernamePage(){}

    @PostMapping("/member/findUsername")
    void findUsername(){}

    @GetMapping("/member/findPassword")
    void findPasswordPage(){}

    @PostMapping("/member/findPassword")
    void findPassword(){}
}
