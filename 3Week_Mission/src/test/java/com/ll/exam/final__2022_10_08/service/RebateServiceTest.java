package com.ll.exam.final__2022_10_08.service;

import com.ll.exam.final__2022_10_08.app.base.dto.RsData;
import com.ll.exam.final__2022_10_08.app.order.entity.Order;
import com.ll.exam.final__2022_10_08.app.order.entity.OrderItem;
import com.ll.exam.final__2022_10_08.app.order.repository.OrderItemRepository;
import com.ll.exam.final__2022_10_08.app.order.repository.OrderRepository;
import com.ll.exam.final__2022_10_08.app.order.service.OrderService;
import com.ll.exam.final__2022_10_08.app.rebate.entity.RebateOrderItem;
import com.ll.exam.final__2022_10_08.app.rebate.service.RebateService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class RebateServiceTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private  OrderItemRepository orderItemRepository;

    @Autowired
    private RebateService rebateService;

    @Test
    @DisplayName("정산데이터를 생성/조회 한다")
    void t1() {

        String yearMonth = "2022-11";
        RsData rsData = rebateService.makeDate(yearMonth);
        List<RebateOrderItem> rebateOrderItems = rebateService.findRebateOrderItemsByPayDateIn(yearMonth);

        Assertions.assertThat(rebateOrderItems).isNotNull();
    }

    @Test
    @DisplayName("정산한다")
    void t2() {
        String yearMonth = "2022-11";
        RsData rsData = rebateService.makeDate(yearMonth);
        List<RebateOrderItem> rebateOrderItems = rebateService.findRebateOrderItemsByPayDateIn(yearMonth);
        List<Long> orderItemIds = new ArrayList<>();

        for(RebateOrderItem rebateOrderItem : rebateOrderItems) {
            orderItemIds.add(rebateOrderItem.getOrderItem().getId());
        }
        for(Long orderItemId : orderItemIds) {
            rebateService.rebate(orderItemId);
        }

        for(RebateOrderItem rebateOrderItem : rebateOrderItems) {
            Assertions.assertThat(rebateOrderItem.getRebateDate()).isNotNull();
        }
    }
}

//    int order1PayPrice = order1.calculatePayPrice();
//        orderService.payByRestCashOnly(order1);
//
//        order1.setPayDate(LocalDateTime.now().minusHours(1));
//        orderRepository.save(order1);
//
//    Order order2 = helper.order(member2, Arrays.asList(
//                    product3,
//                    product4
//            )
//    );
//
//        orderService.payByRestCashOnly(order2);
//
//    Order order3 = helper.order(member2, Arrays.asList(
//                    product1,
//                    product2
//            )
//    );
//
//        cartService.addItem(member1, product3);
//        cartService.addItem(member1, product4);
//
//    Order order4 = helper.order(member2, Arrays.asList(
//                    product3,
//                    product4
//            )
//    );
//
//        orderService.payByRestCashOnly(order4);
//
//    Order order5 = helper.order(member2, Arrays.asList(
//                    product3,
//                    product4
//            )
//    );