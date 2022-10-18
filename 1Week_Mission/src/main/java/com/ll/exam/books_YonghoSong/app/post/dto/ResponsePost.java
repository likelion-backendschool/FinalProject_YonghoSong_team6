package com.ll.exam.books_YonghoSong.app.post.dto;

import com.ll.exam.books_YonghoSong.app.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsePost {
    private String authorName;
    private String subject;
    private String content;
    private String contentHtml;

    public static ResponsePost fromEntity(Post post) {
        return ResponsePost.builder()
                .subject(post.getSubject())
                .content(post.getContent())
                .contentHtml(post.getContentHtml())
                .build();
    }
}
