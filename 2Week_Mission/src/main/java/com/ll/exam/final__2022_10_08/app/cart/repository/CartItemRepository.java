package com.ll.exam.final__2022_10_08.app.cart.repository;


import com.ll.exam.final__2022_10_08.app.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByMemberIdAndProductId(long memberId, long productId);
    List<CartItem> findAllByMemberId(Long memberId);
    boolean existsByMemberIdAndProductId(Long id, Long id1);
    List<CartItem> findAllByMemberIdAndProductIdIn(long memberId, long[] productIds);
}
