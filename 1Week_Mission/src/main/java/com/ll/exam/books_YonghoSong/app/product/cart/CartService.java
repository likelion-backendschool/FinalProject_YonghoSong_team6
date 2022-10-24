package com.ll.exam.books_YonghoSong.app.product.cart;

import com.ll.exam.books_YonghoSong.app.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartItemRepository cartItemRepository;

    public void addItem(Member member) {
        CartItem cartItem = CartItem.builder()
                .member(member)
                .build();

        cartItemRepository.save(cartItem);
    }
}