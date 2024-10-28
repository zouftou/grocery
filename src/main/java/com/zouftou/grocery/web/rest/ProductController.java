package com.zouftou.grocery.web.rest;

import com.zouftou.grocery.service.ProductService;
import com.zouftou.grocery.web.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @RequestMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long idProduct) {
        ProductDto product = productService.getProductById(idProduct);
        return ResponseEntity.ok(product);
    }
}
