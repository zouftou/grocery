package com.zouftou.grocery.web.rest;

import com.zouftou.grocery.service.CustomerService;
import com.zouftou.grocery.service.OrderService;
import com.zouftou.grocery.web.dto.CustomerDto;
import com.zouftou.grocery.web.dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    private final OrderService orderService;

    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @RequestMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        List<CustomerDto> customers = customerService.getCustomers();
        return ResponseEntity.ok(customers);
    }

    @RequestMapping("/customers/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long idCustomer) {
        CustomerDto customer = customerService.getCustomerById(idCustomer);
        return ResponseEntity.ok(customer);
    }

    @RequestMapping("/customers/{id}/orders")
    public ResponseEntity<List<OrderDto>> getOrders(@PathVariable("id") Long idCustomer) {
        List<OrderDto> orders = orderService.getOrderByCustomerId(idCustomer);
        return ResponseEntity.ok(orders);
    }
}
