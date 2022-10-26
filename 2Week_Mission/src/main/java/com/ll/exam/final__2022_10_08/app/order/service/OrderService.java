package com.ll.exam.final__2022_10_08.app.order.service;

import com.ll.exam.final__2022_10_08.app.cart.entity.CartItem;
import com.ll.exam.final__2022_10_08.app.cart.service.CartService;
import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import com.ll.exam.final__2022_10_08.app.member.service.MemberService;
import com.ll.exam.final__2022_10_08.app.mybook.service.MyBookService;
import com.ll.exam.final__2022_10_08.app.order.entity.Order;
import com.ll.exam.final__2022_10_08.app.order.entity.OrderItem;
import com.ll.exam.final__2022_10_08.app.order.repository.OrderRepository;
import com.ll.exam.final__2022_10_08.app.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
    private final MemberService memberService;
    private final CartService cartService;
    private final OrderRepository orderRepository;
    private final MyBookService myBookService;

    /**
     * todo
     * POST /order/create
     * GET /order/list
     * GET /order/{id}
     * POST /order/{id}/cancel
     * POST /order/{id}/pay
     * POST /order/{id}/refund
     */

    @Transactional
    public Order createFromCart(Member member) {

        List<CartItem> cartItems = cartService.getItemsByMember(member);
        List<OrderItem> orderItems = new ArrayList<>();

        // 입력된 회원의 장바구니 아이템들을 전부 가져온다.
        // 만약에 특정 장바구니의 상품옵션이 판매불능이면 삭제
        // 만약에 특정 장바구니의 상품옵션이 판매가능이면 주문품목으로 옮긴 후 삭제
        for (CartItem cartItem : cartItems) {
            Product product = cartItem.getProduct();

            if (product.isOrderable()) {
                orderItems.add(new OrderItem(product));
            }

            cartService.deleteItem(cartItem);
        }

        return create(member, orderItems);
    }

    @Transactional
    public Order create(Member member, List<OrderItem> orderItems) {
        String name;

        try {
            name = "\"" + orderItems.get(0).getProduct().getSubject() + "\"";
            if(orderItems.size()>1)
                name = name + " 외 " +(orderItems.size()-1) + "건";
        } catch (Exception e) {
            name = "이름 없는 주문 ";
        }

        Order order = Order
                .builder()
                .member(member)
                .payDate(LocalDateTime.now())
                .isCanceled(false)
                .isPaid(false)
                .isRefunded(false)
                .readyStatus(true)
                .name(name)
                .build();

        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }

        orderRepository.save(order);

        return order;
    }

    @Transactional
    public void payByRestCashOnly(Order order) {
        Member orderedMember = order.getMember();
        long restCash = orderedMember.getRestCash();
        int payPrice = order.calculatePayPrice();

        if (payPrice > restCash) {
            throw new RuntimeException("예치금이 부족합니다.");
            //subCash 를 사용해도 될 듯
        }

        memberService.addCash(orderedMember, payPrice * -1, "주문결제__예치금결제 : " + order.getName());

        order.setPaymentDone();
        List<OrderItem> orderItems = order.getOrderItems();
        for(OrderItem item : orderItems) {
            myBookService.addItem(orderedMember,item.getProduct());
        }
        orderRepository.save(order);
    }

//    @Transactional
//    public void refund(Order order) {
//        int payPrice = order.getPayPrice();
//        memberService.addCash(order.getMember(), payPrice, "주문환불__예치금환불");
//
//        order.setRefundDone();
//        orderRepository.save(order);
//    }

}
