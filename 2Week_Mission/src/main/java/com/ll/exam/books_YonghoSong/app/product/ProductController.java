package com.ll.exam.books_YonghoSong.app.product;

import com.ll.exam.books_YonghoSong.app.member.Member;
import com.ll.exam.books_YonghoSong.app.post.tags.PostKeyword;
import com.ll.exam.books_YonghoSong.app.product.dto.RequestProductCreate;
import com.ll.exam.books_YonghoSong.app.security.dto.MemberContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;



    @PostMapping("/product/create")
    long createProduct(@RequestBody RequestProductCreate requestProductCreate, @AuthenticationPrincipal MemberContext memberContext) {

        Member member = memberContext.getMember() != null ? memberContext.getMember() : null;

        long productId = productService.create(requestProductCreate,member);



        return -1;
    }
}
