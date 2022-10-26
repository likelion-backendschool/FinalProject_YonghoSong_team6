package com.ll.exam.final__2022_10_08.service;

import com.ll.exam.final__2022_10_08.app.cart.entity.CartItem;
import com.ll.exam.final__2022_10_08.app.cart.repository.CartItemRepository;
import com.ll.exam.final__2022_10_08.app.cart.service.CartService;
import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import com.ll.exam.final__2022_10_08.app.member.repository.MemberRepository;
import com.ll.exam.final__2022_10_08.app.product.entity.Product;
import com.ll.exam.final__2022_10_08.app.product.repository.ProductRepository;
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
//@TestInstance(TestInstance.Lifecycle.PER_CLASS) //@BeforeAll 에서 인스턴스를 사용해야 할 때
public class CartServiceTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Test
    @DisplayName("도서를 장바구니에 담을 수 있다")
    void t1(){
        Member member = memberRepository.findById(1L).get();
        Product product = productRepository.findById(1L).get();
        CartItem cartItem = cartService.addItem(member,product);

        assertThat(cartItem.getMember().getId()).isEqualTo(member.getId());
        assertThat(cartItem.getProduct().getId()).isEqualTo(product.getId());
    }

    @Test
    @DisplayName("장바구니에서 도서를 제거할 수 있다")
    void t2(){
        Member member = memberRepository.findById(1L).get();
        Product product = productRepository.findById(1L).get();
        CartItem cartItem = cartService.addItem(member,product);
        long id = cartItem.getId();
        cartService.deleteItem(cartItem);

        boolean result = cartItemRepository.findById(id).isEmpty();
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("장바구니의 품목 리스트를 조회")
    void t3(){
        Member member = memberRepository.findById(1L).get();

        cartService.addItem(member,productRepository.findById(1L).get());
        cartService.addItem(member,productRepository.findById(2L).get());
        cartService.addItem(member,productRepository.findById(3L).get());
        cartService.addItem(member,productRepository.findById(4L).get());

        List<CartItem> cartItems =  cartService.getItemsByMember(member);
        assertThat(cartItems.size()).isEqualTo(4);
    }
}
