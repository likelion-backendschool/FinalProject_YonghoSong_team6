package com.ll.exam.books_YonghoSong.app.security;

import com.ll.exam.books_YonghoSong.app.member.Member;
import com.ll.exam.books_YonghoSong.app.member.MemberRepository;
import com.ll.exam.books_YonghoSong.app.member.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("해당 ID 의 맴버가 없습니다."));

        List<GrantedAuthority> authorities = new ArrayList<>();
        switch (member.getAuthLevel()) {
            case 4, 5, 6 -> authorities.add(new SimpleGrantedAuthority(UserRole.AUTHOR.getValue()));
            case 7 -> authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
            default -> authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }

        return new User(member.getUsername(), member.getPassword(), authorities);
    }
}
