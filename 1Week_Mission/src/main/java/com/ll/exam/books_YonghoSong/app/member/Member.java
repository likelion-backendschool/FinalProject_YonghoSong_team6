package com.ll.exam.books_YonghoSong.app.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.exam.books_YonghoSong.app.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Member extends BaseEntity {

    @Column(unique = true)
    private String username;
    //@JsonIgnore
    private String password;
    private String nickname;
    private String email;
    //private int authLevel;

}
