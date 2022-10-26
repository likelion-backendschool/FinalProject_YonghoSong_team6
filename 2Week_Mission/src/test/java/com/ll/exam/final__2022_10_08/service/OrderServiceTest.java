package com.ll.exam.final__2022_10_08.service;

import com.ll.exam.final__2022_10_08.app.cart.service.CartService;
import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import com.ll.exam.final__2022_10_08.app.member.repository.MemberRepository;
import com.ll.exam.final__2022_10_08.app.order.entity.Order;
import com.ll.exam.final__2022_10_08.app.order.service.OrderService;
import com.ll.exam.final__2022_10_08.app.product.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductRepository productRepository;



    @Test
    @DisplayName("장바구니에서 주문을 만들 수 있다.")
    void t1(){
        Member member = memberRepository.findById(1L).get();

        cartService.addItem(member,productRepository.findById(1L).get());
        cartService.addItem(member,productRepository.findById(2L).get());
        cartService.addItem(member,productRepository.findById(3L).get());
        cartService.addItem(member,productRepository.findById(4L).get());

        Order order = orderService.createFromCart(member);
        //노가다 안 하는 법... Dev init data?

        assertThat(order.getMember().getId()).isEqualTo(member.getId());
        assertThat(order.getOrderItems().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("준비 상태의 주문에서 결제한다.")
    void t2(){
        Member member = memberRepository.findById(1L).get();

        cartService.addItem(member,productRepository.findById(1L).get());
        cartService.addItem(member,productRepository.findById(2L).get());
        cartService.addItem(member,productRepository.findById(3L).get());
        cartService.addItem(member,productRepository.findById(4L).get());

        Order order = orderService.createFromCart(member);
        //주문 만들기



    }

    @Test
    @DisplayName("준비 상태의 주문에서 취소한다.")
    void t3(){

    }
}
