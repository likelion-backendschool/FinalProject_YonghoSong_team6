package com.ll.exam.books_YonghoSong.app.product.order;

import com.ll.exam.books_YonghoSong.app.base.BaseEntity;
import com.ll.exam.books_YonghoSong.app.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Order extends BaseEntity {

    @ManyToOne(fetch = LAZY)
    private Member member;


    private LocalDateTime payDate;
    private boolean readyStatus;
    private boolean isPaid;
    private boolean isCanceled;
    private boolean isRefunded;
    private String name;
}
