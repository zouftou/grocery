package com.zouftou.grocery.model;

import jakarta.persistence.*;

@Entity
public class OrderLine {

    @Id
    @GeneratedValue
    private Long id;
    private Integer amount;

    private Double purchasePrice;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
