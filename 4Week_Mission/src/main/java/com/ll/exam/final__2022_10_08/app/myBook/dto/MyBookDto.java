package com.ll.exam.final__2022_10_08.app.myBook.dto;

import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import com.ll.exam.final__2022_10_08.app.myBook.entity.MyBook;
import com.ll.exam.final__2022_10_08.app.product.dto.ProductDto;
import com.ll.exam.final__2022_10_08.app.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class MyBookDto {
    Long id;
    List<Integer> createDate;
    List<Integer> modifyDate;
    Long ownerId;
    List<ProductDto> product;
    Long authorId;
    String authorName;
    String subject;

    static MyBookDto fromEntity(MyBook myBook){


        Product productEntity = myBook.getProduct();
        Member author = productEntity.getAuthor();
        Member owner = myBook.getOwner();
//        List<Integer> createDateList = new ArrayList<>();
//        createDateList.add(myBook.getCreateDate().getYear());
//        createDateList.add(myBook.getCreateDate().getMonth());
//        createDateList.add(myBook.getCreateDate().getYear());
//        createDateList.add(myBook.getCreateDate().getYear());
//
//
//        LocalDateTime modifyDateObj = myBook.getModifyDate();
//

        return MyBookDto.builder()
                .id(myBook.getId())
                .createDate()
                .modifyDate()

                .ownerId(owner.getId())
                //product

                .authorId(author.getId())
                .authorName(author.getNickname())
                .subject(productEntity.getSubject())
                .build();
    }

}
