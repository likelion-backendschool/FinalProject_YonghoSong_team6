package com.ll.exam.books_YonghoSong.app.member.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestCreateMember {
    private String username;
    private String password;
    private String email;
}
