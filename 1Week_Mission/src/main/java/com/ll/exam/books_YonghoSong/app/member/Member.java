package com.ll.exam.books_YonghoSong.app.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.exam.books_YonghoSong.app.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
public class Member extends BaseEntity{
    @Column(unique = true)
    private String username;
    //@JsonIgnore
    private String password;
    @Column(unique = true)
    private String nickname;
    @Column(unique = true)
    private String email;
    @Builder.Default
    private int authLevel=1;

    public Member(long id){super(id);}
}
