package com.zouftou.grocery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String text;
}
