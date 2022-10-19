package com.ll.exam.books_YonghoSong.app.member;

import com.ll.exam.books_YonghoSong.app.member.dto.create.RequestCreateMember;
import com.ll.exam.books_YonghoSong.app.member.dto.modify.RequestModifyMember;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    long createMember (RequestCreateMember requestCreateMember){

        memberRepository.findByEmail(requestCreateMember.getEmail()).ifPresent(
                member -> {throw new IllegalArgumentException("이메일이 중복되었습니다.");}
        );
        memberRepository.findByEmail(requestCreateMember.getUsername()).ifPresent(
                member -> {throw new IllegalArgumentException("유저네임이 중복되었습니다.");}
        );
        Member member = Member.builder()
                .email(requestCreateMember.getEmail())
                .password(passwordEncoder.encode(requestCreateMember.getPassword()))
                .username(requestCreateMember.getUsername())
                .build();
        long id = memberRepository.save(member).getId();
        return id;
    }

    public long updateMember(RequestModifyMember requestModifyMember) {


        memberRepository.findByEmail(requestModifyMember.getEmail()).ifPresent(
                member -> {throw new IllegalArgumentException("이메일이 중복되었습니다.");}
        );
        memberRepository.findByEmail(requestModifyMember.getNickname()).ifPresent(
                member -> {throw new IllegalArgumentException("닉네임이 중복되었습니다.");}
        );
        memberRepository.findByEmail(requestModifyMember.getUsername()).ifPresent(
                member -> {throw new IllegalArgumentException("유저네임이 중복되었습니다.");}
        );

        Member member = memberRepository.findById(requestModifyMember.getId())
                .orElseThrow(() -> new NoSuchElementException("MEMBER ID 잘못됨"));


        if(!requestModifyMember.getEmail().isEmpty())
            member.setEmail(requestModifyMember.getEmail());
        if(!requestModifyMember.getNickname().isEmpty()) {
            member.setNickname(requestModifyMember.getNickname());
            member.setAuthLevel(4);
        }
        if(!requestModifyMember.getUsername().isEmpty())
            member.setUsername(requestModifyMember.getUsername());

        long id = memberRepository.save(member).getId();
        return id;
    }


    public String findUsernameByEmail(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("해당 Email 에 해당하는 맴버가 없습니다."));
       return member.getUsername();
    }

    public Member findByUsername(String username){
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("해당 유저네임의 회원이 없습니다."));
        return member;
    }

    public Member findByNickname(String authorName) {
        Member member = memberRepository.findByNickname(authorName)
                .orElseThrow(() -> new NoSuchElementException("해당 닉네임의 회원이 없습니다."));
        return member;
    }
}
