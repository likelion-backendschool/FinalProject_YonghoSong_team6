package com.ll.exam.books_YonghoSong.app.post;

import com.ll.exam.books_YonghoSong.app.base.BaseEntity;
import com.ll.exam.books_YonghoSong.app.member.Member;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Post extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member author;
    private String subject;
    private String content;
    private String contentHtml;
}
