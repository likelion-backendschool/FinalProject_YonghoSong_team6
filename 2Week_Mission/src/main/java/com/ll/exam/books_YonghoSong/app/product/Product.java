package com.ll.exam.books_YonghoSong.app.product;


import com.ll.exam.books_YonghoSong.app.base.BaseEntity;
import com.ll.exam.books_YonghoSong.app.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Product extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member author;



    private String subject;
    private long price;
}
