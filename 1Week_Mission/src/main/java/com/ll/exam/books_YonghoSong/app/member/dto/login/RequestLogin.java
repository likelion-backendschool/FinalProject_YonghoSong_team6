package com.ll.exam.books_YonghoSong.app.member.dto.login;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestLogin {
   private String username;
   private String password;
}
