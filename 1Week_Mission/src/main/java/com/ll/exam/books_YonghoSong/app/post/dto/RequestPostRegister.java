package com.ll.exam.books_YonghoSong.app.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestPostRegister {

    private String authorName;
    private String subject;
    private String content;
    private String contentHtml;
}
