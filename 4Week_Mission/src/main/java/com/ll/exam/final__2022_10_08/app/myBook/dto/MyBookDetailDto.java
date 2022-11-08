package com.ll.exam.final__2022_10_08.app.myBook.dto;

import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import com.ll.exam.final__2022_10_08.app.myBook.entity.MyBook;
import com.ll.exam.final__2022_10_08.app.post.dto.PostDto;
import com.ll.exam.final__2022_10_08.app.product.dto.ProductDto;
import com.ll.exam.final__2022_10_08.app.product.entity.Product;
import com.ll.exam.final__2022_10_08.util.DateTimeParser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class MyBookDetailDto{ //상속해도 될 듯..?
    Long id;
    List<Integer> createDate;
    List<Integer> modifyDate;
    Long ownerId;
    ProductDto product;
    Long authorId;
    String authorName;
    String subject;
    List<PostDto> bookChapters; //밖에서 만들어서 넣어줘야 함.

    static MyBookDetailDto fromEntity(@NotNull MyBook myBook){

        Product productEntity = myBook.getProduct();
        Member author = productEntity.getAuthor();
        Member owner = myBook.getOwner();
        List<Integer> createDateList = DateTimeParser.dateTimeToIntegerList(myBook.getCreateDate());
        List<Integer> modifyDateList = DateTimeParser.dateTimeToIntegerList(myBook.getModifyDate());

        return MyBookDetailDto.builder()
                .id(myBook.getId())
                .createDate(createDateList)
                .modifyDate(modifyDateList)
                .ownerId(owner.getId())
                .product(ProductDto.fromEntity(productEntity))
                .authorId(author.getId())
                .authorName(author.getNickname())
                .subject(productEntity.getSubject())
                .build();
    }
    public MyBookDetailDto(@NotNull MyBookDto myBookDto)
    {
        id = myBookDto.getId();
        createDate = myBookDto.getCreateDate();
        modifyDate = myBookDto.getModifyDate();
        ownerId = myBookDto.getOwnerId();
        product = myBookDto.getProduct();
        authorId = myBookDto.getAuthorId();
        authorName = myBookDto.getAuthorName();
        subject = myBookDto.getSubject();
    }
}