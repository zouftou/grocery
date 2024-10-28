package com.zouftou.grocery.service;

import com.zouftou.grocery.model.Customer;
import com.zouftou.grocery.model.Product;
import com.zouftou.grocery.repository.ProductRepository;
import com.zouftou.grocery.web.dto.CustomerDto;
import com.zouftou.grocery.web.dto.ProductDto;
import com.zouftou.grocery.web.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    public ProductDto getProductById(final Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            return modelMapper.map(product.get(), ProductDto.class);
        } else {
            throw new ResourceNotFoundException("Product","id",id);
        }
    }
}
