package com.zouftou.grocery.service;

import com.zouftou.grocery.model.Customer;
import com.zouftou.grocery.model.Order;
import com.zouftou.grocery.repository.OrderRepository;
import com.zouftou.grocery.web.dto.CustomerDto;
import com.zouftou.grocery.web.dto.OrderDto;
import com.zouftou.grocery.web.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final ModelMapper modelMapper;

    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    public List<OrderDto> getOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .toList();
    }

    public OrderDto getOrderById(final Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()) {
            return modelMapper.map(order.get(), OrderDto.class);
        } else {
            throw new ResourceNotFoundException("Order","id",id);
        }
    }

    public List<OrderDto> getOrderByCustomerId(final Long customerId) {
        return orderRepository.findByCustomerId(customerId)
                .stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .toList();
    }
}
