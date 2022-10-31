package com.ll.exam.final__2022_10_08.app.mybook.service;

import com.ll.exam.final__2022_10_08.app.cart.entity.MyBook;
import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import com.ll.exam.final__2022_10_08.app.member.service.MemberService;
import com.ll.exam.final__2022_10_08.app.mybook.repository.MyBookRepository;
import com.ll.exam.final__2022_10_08.app.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyBookService {
    private final MemberService memberService;
    private final MyBookRepository myBookRepository;


    public MyBook addItem(Member member, Product product) {
        MyBook oldMyBook = myBookRepository.findByMemberIdAndProductId(member.getId(), product.getId())
                .orElse(null);
        if(oldMyBook != null) {
            //이미 가지고 있을 때?
            return oldMyBook;
        }
        MyBook myBook = MyBook.builder()
                .member(member)
                .product(product)
                .build();
        myBookRepository.save(myBook);
        return myBook;
    }
    public List<MyBook> getItemsByMember(Member member) {
        return myBookRepository.findAllByMemberId(member.getId());
    }
}
