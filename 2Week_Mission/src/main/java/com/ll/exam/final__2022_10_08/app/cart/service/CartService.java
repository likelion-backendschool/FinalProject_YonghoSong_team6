package com.ll.exam.final__2022_10_08.app.cart.service;


import com.ll.exam.final__2022_10_08.app.cart.entity.CartItem;
import com.ll.exam.final__2022_10_08.app.cart.repository.CartItemRepository;
import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartItemRepository cartItemRepository;
    /** todo
     * GET /cart/list
     * POST /cart/remove/{productId}
     * POST /cart/add/{productId}
     */

    public CartItem addItem(Member member, int num) {


        return null;
    }

//    public List<CartItem> getItemsByMember(Member member) {
//        return cartItemRepository.findAllByMemberId(member.getId());
//    }

    public void deleteItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }
}
