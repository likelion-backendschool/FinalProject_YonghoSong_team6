package com.ll.exam.books_YonghoSong.app.product;

import com.ll.exam.books_YonghoSong.app.member.Member;
import com.ll.exam.books_YonghoSong.app.product.dto.RequestProductCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public long create(RequestProductCreate requestProductCreate, Member author) {
        Product product = new Product();
        product.setAuthor(author);
        product.setPrice(requestProductCreate.getPrice());
        product.setSubject(requestProductCreate.getSubject());
        //해시태그 연결 추가해야함

        productRepository.save(product);
        return product.getId();
    }
}
