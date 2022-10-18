package com.ll.exam.books_YonghoSong.app.member;


import com.ll.exam.books_YonghoSong.app.member.dto.create.RequestCreateMember;
import com.ll.exam.books_YonghoSong.app.member.dto.modify.RequestModifyMember;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    /**
     * todo
     * Primary : 회원가입 O, 회원정보수정 O, 로그인, 로그아웃, 아이디찾기
     * Optional : 비번찾기
     */

    private final MemberService memberService;

    @GetMapping("/member/join")
    void joinPage(){
        //front form
    }

    @PostMapping("/member/join")
    long join(@RequestBody RequestCreateMember requestCreateMember){
        /*
        * http://localhost:8084/member/join
        * */

        long id = memberService.createMember(requestCreateMember);
        return id;
    }

    @GetMapping("/member/login")
    void loginPage(){
        //front form
    }

    @PostMapping("/member/login")
    void login(){
        //security
    }

    @GetMapping("/member/logout")
    void logout(){
        //security
    }

    @GetMapping("/member/modify")
    void modifyPage(){}

    @PostMapping("/member/modify")
    long modify(@RequestBody RequestModifyMember requestModifyMember){

        long id = memberService.updateMember(requestModifyMember);
        return id;
    }

    @GetMapping("/member/modifyPassword")
    void modifyPasswordPage(){
        //front form
    }

    @PostMapping("/member/modifyPassword")
    void modifyPassword(){}

    @GetMapping("/member/findUsername")
    void findUsernamePage(){
        //front form
    }

    @PostMapping("/member/findUsername")
    String findUsername(@RequestBody String email){
        String Username = memberService.findUsernameByEmail(email);
        return Username;
    }

    @GetMapping("/member/findPassword")
    void findPasswordPage(){}

    @PostMapping("/member/findPassword")
    void findPassword(){}
}
