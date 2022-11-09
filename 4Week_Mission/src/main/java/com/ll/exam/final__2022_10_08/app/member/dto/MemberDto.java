package com.ll.exam.final__2022_10_08.app.member.dto;

import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import com.ll.exam.final__2022_10_08.util.DateTimeParser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class MemberDto {
    Long id;
    List<Integer> createDate;
    List<Integer> modifyDate;
    String username;
    String email;
    boolean emailVerified = false;
    String nickname = "";

    public static MemberDto fromEntity(Member member){
        List<Integer> createDateList = DateTimeParser.dateTimeToIntegerList(member.getCreateDate());
        List<Integer> modifyDateList = DateTimeParser.dateTimeToIntegerList(member.getModifyDate());

        return MemberDto.builder()
                .id(member.getId())
                .createDate(createDateList)
                .modifyDate(modifyDateList)
                .username(member.getUsername())
                .email(member.getEmail())
                .emailVerified(member.isEmailVerified())
                .nickname(member.getNickname() == null ? "" : member.getNickname())
                .build();
    }

}
