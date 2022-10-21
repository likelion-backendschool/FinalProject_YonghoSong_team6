package com.ll.exam.books_YonghoSong.app.post.tags;

import com.ll.exam.books_YonghoSong.app.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PostKeyword extends BaseEntity {
    private String content;
}
