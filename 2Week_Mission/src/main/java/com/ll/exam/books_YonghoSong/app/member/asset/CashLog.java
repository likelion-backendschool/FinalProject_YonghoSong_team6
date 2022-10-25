package com.ll.exam.books_YonghoSong.app.member.asset;

import com.ll.exam.books_YonghoSong.app.base.BaseEntity;
import com.ll.exam.books_YonghoSong.app.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class CashLog extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private long price; // cashDiff 라고 부르는게 맞지 않을까

    private String eventType; // 잔고가 변한 이유
}
