package ru.gb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Product {
    private int id;
    private String name;
    private float price;
}
