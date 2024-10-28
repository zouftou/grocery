package com.zouftou.grocery.web.rest;

import com.zouftou.grocery.service.OrderService;
import com.zouftou.grocery.web.dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/orders")
    public ResponseEntity<List<OrderDto>> getOrders() {
        List<OrderDto> orders = orderService.getOrders();
        return ResponseEntity.ok(orders);
    }

    @RequestMapping("/orders/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") Long idOrder) {
        OrderDto order = orderService.getOrderById(idOrder);
        return ResponseEntity.ok(order);
    }

    @RequestMapping("/customers/{idCustomer}/orders")
    public ResponseEntity<List<OrderDto>> getOrders(@PathVariable("idCustomer") Long idCustomer) {
        List<OrderDto> orders = orderService.getOrderByCustomerId(idCustomer);
        return ResponseEntity.ok(orders);
    }
}
