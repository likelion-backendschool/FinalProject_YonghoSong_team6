package com.ll.exam.books_YonghoSong.app.post.tags;

import com.ll.exam.books_YonghoSong.app.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class PostKeyword extends BaseEntity {
    private String content;
}
