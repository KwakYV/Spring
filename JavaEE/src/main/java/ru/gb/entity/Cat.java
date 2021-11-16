package ru.gb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Cat {
    private String name;
    private int age;
    private List<Cat> children;
}
