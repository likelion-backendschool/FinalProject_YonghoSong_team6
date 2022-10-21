package com.ll.exam.books_YonghoSong.app.member.dto.modify;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestModifyMember {
    private long id;
    private String username;
    private String nickname;
    private String email;
}