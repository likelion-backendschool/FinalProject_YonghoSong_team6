package com.ll.exam.final__2022_10_08.app.post.dto;

import com.ll.exam.final__2022_10_08.app.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class PostDto {
    Long id;
    String subject;
    String content;
    String contentHtml;

    public static PostDto fromEntity(@NotNull Post post)
    {
        return PostDto.builder()
                .id(post.getId())
                .subject(post.getSubject())
                .content(post.getContent())
                .contentHtml(post.getContentHtml())
                .build();
    }
}
