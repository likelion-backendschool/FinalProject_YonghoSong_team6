package com.ll.exam.books_YonghoSong.app.member;

import com.ll.exam.books_YonghoSong.app.member.dto.RequestCreateMember;
import com.ll.exam.books_YonghoSong.app.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    long createMember (RequestCreateMember requestCreateMember){

        memberRepository.findByEmail(requestCreateMember.getEmail()).ifPresent(
                member -> {throw new IllegalArgumentException("이메일이 중복되었습니다.");}
        );
        memberRepository.findByEmail(requestCreateMember.getNickname()).ifPresent(
                member -> {throw new IllegalArgumentException("닉네임이 중복되었습니다.");}
        );
        memberRepository.findByEmail(requestCreateMember.getUsername()).ifPresent(
                member -> {throw new IllegalArgumentException("유저네임이 중복되었습니다.");}
        );
        Member member = Member.builder()
                .email(requestCreateMember.getEmail())
                .nickname(requestCreateMember.getNickname())
                .password(requestCreateMember.getPassword())
                .username(requestCreateMember.getUsername())
                .build();
        long id = memberRepository.save(member).getId();
        return id;
    }

}
