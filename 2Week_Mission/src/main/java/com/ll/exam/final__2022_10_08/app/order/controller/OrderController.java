package com.ll.exam.final__2022_10_08.app.order.controller;

import com.ll.exam.final__2022_10_08.app.base.rq.Rq;
import com.ll.exam.final__2022_10_08.app.member.entity.Member;
import com.ll.exam.final__2022_10_08.app.order.entity.Order;
import com.ll.exam.final__2022_10_08.app.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    /**
     * todo
     * GET /order/list
     * GET /order/{id}
     * POST /order/create
     * POST /order/{id}/pay
     * POST /order/{id}/cancel ?
     * POST /order/{id}/refund X
     */

    private final Rq rq;
    private final OrderService orderService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/order/list")
    public String orderList(Model model){
        Member member = rq.getMember();
        List<Order> orders = orderService.findAllOrderByMember(member);
        model.addAttribute("orders",orders);
        return "/order/list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/order/{id}")
    public String orderDetail(Model model, @RequestParam long id){
        Order order = orderService.findById(id);
        model.addAttribute("order",order);
        return "/order/"+id;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/order/create")
    public String createOrder() {
        Member member = rq.getMember();
        Order order = orderService.createFromCart(member);
        return Rq.redirectWithMsg("/order/" + order.getId(), "주문이 생성되었습니다.");
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/order/{id}/pay")
    public String payOrder(@RequestParam long id) {
        Order order = orderService.findById(id);
        orderService.payByRestCashOnly(order);
        return Rq.redirectWithMsg("/order/"+id, "주문 결제가 완료 되었습니다.");
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/order/{id}/cancel")
    public String cancelOrder(@RequestParam long id) {
        Order order = orderService.findById(id);
        orderService.cancelOrder(order);
        return Rq.redirectWithMsg("/order/"+id, "주문 결제가 취소 되었습니다.");
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/order/{id}/refund")
    public String refundOrder(@RequestParam long id){
        Order order = orderService.findById(id);
        orderService.refund(order);
        return Rq.redirectWithMsg("/order/"+id, "주문번호 %d번 주문이 환불처리 되었습니다.");
    }
}
