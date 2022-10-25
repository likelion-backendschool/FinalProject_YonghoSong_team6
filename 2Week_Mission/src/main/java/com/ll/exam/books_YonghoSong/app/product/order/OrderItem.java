package com.ll.exam.books_YonghoSong.app.product.order;

import com.ll.exam.books_YonghoSong.app.base.BaseEntity;
import com.ll.exam.books_YonghoSong.app.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class OrderItem extends BaseEntity {
    @ManyToOne // 1:1 인지 n:1 인지 확인할 것
    @JoinColumn(name = "order_id")
    private Order Order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private LocalDateTime payDate;
    private long price;
    private long salePrice;
    private long wholesalePrice;
    private long pgFee;
    private long payPrice;
    private long refundPrice;
    private boolean isPaid;
}
