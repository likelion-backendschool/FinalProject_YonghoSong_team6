package com.ll.exam.final__2022_10_08.app.cart.controller;

import com.ll.exam.final__2022_10_08.app.base.rq.Rq;
import com.ll.exam.final__2022_10_08.app.cart.entity.CartItem;
import com.ll.exam.final__2022_10_08.app.cart.service.CartService;
import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import com.ll.exam.final__2022_10_08.app.product.entity.Product;
import com.ll.exam.final__2022_10_08.app.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
public class CartController {
    /**
    * todo
    * GET /cart/list
    * POST /cart/remove/{productId}
    * POST /cart/add/{productId}
    */

    private final Rq rq;
    private final CartService cartService;
    private final ProductService productService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/cart/list")
    public String CartList (Model model){
        Member member = rq.getMember();
        List<CartItem> cartItems = cartService.getItemsByMember(member);

        model.addAttribute("CartItems", cartItems);
        return "/cart/list";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/cart/add/{productId}")
    public String addProduct(@RequestParam long productId) {
        Member member = rq.getMember();
        Product product = productService.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("해당 ID 의 제품은 존재하지 않습니다"));
        cartService.addItem(member,product);
        return Rq.redirectWithMsg("/cart/list","상품이 장바구니에 추가되었습니다." );
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/cart/remove/{productId}")
    public String removeProduct(@RequestParam long productId) {
        Member member = rq.getMember();
        Product product = productService.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("해당 ID 의 제품은 존재하지 않습니다"));
        cartService.deleteItem(member, product);
        return Rq.redirectWithMsg("/cart/list", "상품이 장바구니서 제거되었습니다.");
    }
}
