package com.ll.exam.final__2022_10_08.service;


import com.ll.exam.final__2022_10_08.app.cart.entity.CartItem;
import com.ll.exam.final__2022_10_08.app.cart.repository.CartItemRepository;
import com.ll.exam.final__2022_10_08.app.cart.service.CartService;
import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import com.ll.exam.final__2022_10_08.app.member.repository.MemberRepository;
import com.ll.exam.final__2022_10_08.app.product.entity.Product;
import com.ll.exam.final__2022_10_08.app.product.repository.ProductRepository;
import com.ll.exam.final__2022_10_08.app.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class CartServiceTests {
    @Autowired
    private ProductService productService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Test
    @DisplayName("장바구니에 담기")
    void t1() {
        Member buyer = memberRepository.findByUsername("user1").get();

        Product product1 = productService.findById(1).get();
        Product product2 = productService.findById(2).get();
        Product product3 = productService.findById(3).get();
        Product product4 = productService.findById(4).get();

        CartItem cartItem1 = cartService.addItem(buyer, product1);
        CartItem cartItem2 = cartService.addItem(buyer, product2);
        CartItem cartItem3 = cartService.addItem(buyer, product3);
        CartItem cartItem4 = cartService.addItem(buyer, product4);

        assertThat(cartItem1).isNotNull();
        assertThat(cartItem2).isNotNull();
        assertThat(cartItem3).isNotNull();
        assertThat(cartItem4).isNotNull();
    }

    @Test
    @DisplayName("장바구니에서 제거")
    void t2() {
        Member buyer1 = memberRepository.findByUsername("user1").get();
        Member buyer2 = memberRepository.findByUsername("user2").get();

        Product product1 = productService.findById(1).get();
        Product product2 = productService.findById(2).get();
        Product product3 = productService.findById(3).get();
        Product product4 = productService.findById(4).get();

        cartService.removeItem(buyer1, product1);
        cartService.removeItem(buyer1, product2);
        cartService.removeItem(buyer2, product3);
        cartService.removeItem(buyer2, product4);

        assertThat(cartService.hasItem(buyer1, product1)).isFalse();
        assertThat(cartService.hasItem(buyer1, product1)).isFalse();
        assertThat(cartService.hasItem(buyer1, product1)).isFalse();
        assertThat(cartService.hasItem(buyer1, product1)).isFalse();
    }


    @Test
    @DisplayName("도서를 장바구니에 담을 수 있다")
    void t3(){
        Member member = memberRepository.findById(1L).get();
        Product product = productRepository.findById(1L).get();
        CartItem cartItem = cartService.addItem(member,product);

        assertThat(cartItem.getBuyer().getId()).isEqualTo(member.getId());
        assertThat(cartItem.getProduct().getId()).isEqualTo(product.getId());
    }

    @Test
    @DisplayName("장바구니에서 도서를 제거할 수 있다")
    void t4(){
        Member member = memberRepository.findById(1L).get();
        Product product = productRepository.findById(1L).get();
        CartItem cartItem = cartService.addItem(member,product);
        long id = cartItem.getId();
        cartService.removeItem(cartItem);

        boolean result = cartItemRepository.findById(id).isEmpty();
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("장바구니의 품목 리스트를 조회")
    void t5(){
        Member member = memberRepository.findById(1L).get();

        cartService.addItem(member,productRepository.findById(1L).get());
        cartService.addItem(member,productRepository.findById(2L).get());
        cartService.addItem(member,productRepository.findById(3L).get());
        cartService.addItem(member,productRepository.findById(4L).get());

        List<CartItem> cartItems =  cartService.getItemsByBuyer(member);
        assertThat(cartItems.size()).isEqualTo(4);
    }
}
