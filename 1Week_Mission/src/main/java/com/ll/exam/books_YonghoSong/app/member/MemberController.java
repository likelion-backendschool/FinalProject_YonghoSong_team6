package com.ll.exam.books_YonghoSong.app.member;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @GetMapping("/member/login")
    void loginPage(){}

    @PostMapping("/member/login")
    void login(){}

    @GetMapping("/member/logout")
    void logout(){}

    @GetMapping("/member/join")
    void joinPage(){}

    @PostMapping("/member/join")
    void join(){}

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

    @GetMapping("/member/findPassword")
    void findPassword(){}
}
