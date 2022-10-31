package com.ll.exam.final__2022_10_08.app.cart.service;


import com.ll.exam.final__2022_10_08.app.cart.entity.CartItem;
import com.ll.exam.final__2022_10_08.app.cart.repository.CartItemRepository;
import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import com.ll.exam.final__2022_10_08.app.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartItemRepository cartItemRepository;
    /** todo
     * GET /cart/list
     * POST /cart/remove/{productId}
     * POST /cart/add/{productId}
     */

    public CartItem addItem(Member member, Product product) {
        CartItem oldCartItem = cartItemRepository.findByMemberIdAndProductId(member.getId(), product.getId())
                .orElse(null);
        if ( oldCartItem != null )
            return oldCartItem;
        //이미 장바구니에 있다면 기존 사항을 반환

        CartItem cartItem = CartItem.builder()
                .member(member)
                .product(product)
                .build();
        cartItemRepository.save(cartItem);
        return cartItem;
        //새로 추가하고 반환
    }

    public List<CartItem> getItemsByMember(Member member) {
        return cartItemRepository.findAllByMemberId(member.getId());
    }

    @Transactional
    public void deleteItem(Member member, Product product)
    {
        CartItem CartItem = cartItemRepository.findByMemberIdAndProductId(member.getId(), product.getId())
                .orElseThrow(() -> new RuntimeException("삭제할 장바구니 항목이 존재하지 않습니다."));
        deleteItem(CartItem);
    }
    @Transactional
    public void deleteItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }


    public boolean hasItem(Member member, Product product) {
        return cartItemRepository.existsByMemberIdAndProductId(member.getId(), product.getId());
    }

    public Optional<CartItem> findItemById(long id) {
        return cartItemRepository.findById(id);
    }

    public boolean actorCanDelete(Member buyer, CartItem cartItem) {
        return buyer.getId().equals(cartItem.getMember().getId());
    }

    public List<CartItem> getCartItemsByBuyerIdProductIdIn(long MemberId, long[] productIds) {
        return cartItemRepository.findAllByMemberIdAndProductIdIn(MemberId, productIds);
    }
}

