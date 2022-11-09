package com.ll.exam.final__2022_10_08.app.member.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberRestController {
    @GetMapping("/api/v1/member/me")
    void showProfile(){
    }

    @PostMapping("/api/v1/member/login")
    void login(){

    }

}
