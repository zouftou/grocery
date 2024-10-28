package com.zouftou.grocery.service;

import com.zouftou.grocery.model.Customer;
import com.zouftou.grocery.repository.CustomerRepository;
import com.zouftou.grocery.web.dto.CustomerDto;
import com.zouftou.grocery.web.dto.ProductDto;
import com.zouftou.grocery.web.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public List<CustomerDto> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .toList();
    }

    public CustomerDto getCustomerById(final Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            return modelMapper.map(customer.get(), CustomerDto.class);
        } else {
            throw new ResourceNotFoundException("Customer","id",id);
        }
    }
}
