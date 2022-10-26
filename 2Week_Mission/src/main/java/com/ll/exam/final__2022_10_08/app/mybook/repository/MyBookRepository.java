package com.ll.exam.final__2022_10_08.app.mybook.repository;

import com.ll.exam.final__2022_10_08.app.cart.entity.MyBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MyBookRepository extends JpaRepository<MyBook, Long> {
    Optional<MyBook> findByMemberIdAndProductId(long memberId, long productId);
    List<MyBook> findAllByMemberId(Long memberId);
}
