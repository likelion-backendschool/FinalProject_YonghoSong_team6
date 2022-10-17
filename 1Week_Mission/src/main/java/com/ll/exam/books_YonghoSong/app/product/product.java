package com.ll.exam.books_YonghoSong.app.product;


import com.ll.exam.books_YonghoSong.app.base.BaseEntity;
import com.ll.exam.books_YonghoSong.app.member.Member;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class product extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member author;



    private String subject;
    private long price;
}
