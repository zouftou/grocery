package com.zouftou.grocery.web.rest;

import com.zouftou.grocery.service.CustomerService;
import com.zouftou.grocery.web.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
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
}
