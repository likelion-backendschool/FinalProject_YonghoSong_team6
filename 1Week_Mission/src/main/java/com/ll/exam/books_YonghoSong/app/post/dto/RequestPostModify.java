package com.ll.exam.books_YonghoSong.app.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class RequestPostModify {

    private String subject;
    private String content;
    private String contentHtml;
}
