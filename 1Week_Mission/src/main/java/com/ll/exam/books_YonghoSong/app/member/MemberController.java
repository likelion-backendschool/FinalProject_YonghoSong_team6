package com.ll.exam.books_YonghoSong.app.member;


import com.ll.exam.books_YonghoSong.app.member.dto.create.RequestCreateMember;
import com.ll.exam.books_YonghoSong.app.member.dto.login.RequestLogin;
import com.ll.exam.books_YonghoSong.app.member.dto.modify.RequestModifyMember;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    /**
     * todo
     * Primary : 회원가입 O, 회원정보수정 O, 로그인 O, 로그아웃 O, 아이디찾기 O
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
        * http://localhost:8080/member/join
        *
        * "username" : "TestAdmin",
        * "password" : "admin1234",
        * "email" : "spphire2@naver.com"
        *
        * */
        long id = memberService.createMember(requestCreateMember);
        return id;
    }

    @GetMapping("/member/login")
    String loginPage(){
        return """
                <html layout:decorate="~{layout}">
                <div layout:fragment="content" class="container my-3">
                    <form th:action="@{/member/login}" method="post">
                        <div th:if="${param.error}">
                            <div class="alert alert-danger">
                                사용자 ID 또는 비밀번호를 확인해 주세요.
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="username" class="form-label">사용자ID</label>
                            <input type="text" name="username" id="username" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">비밀번호</label>
                            <input type="password" name="password" id="password" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-primary">로그인</button>
                    </form>
                </div>
                </html>
                """;
    }

    @PostMapping("/member/login")
    String login(@RequestBody RequestLogin requestLogin){
        // security
        // http://localhost:8080/member/login
        // https://github.com/jhs512/sb_exam_2022_09_05__app10/blob/master/src/main/java/com/ll/exam/app10/app/security/SecurityConfig.java
        // https://wiken.io/ken/10164
        // https://www.youtube.com/watch?v=m3AHpdfznsg

        return "";
    }

    @GetMapping("/member/logout")
    void logout(){
        // security
        // http://localhost:8080/member/logout
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
