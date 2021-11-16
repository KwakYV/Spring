package ru.gb.service;

import ru.gb.entity.Cat;

import java.util.Arrays;
import java.util.List;

public class CatService {
    public Cat getCat(){
        List<Cat> kids = Arrays.asList(
                new Cat("Niki", 1, null),
                new Cat("Tishka", 1, null)
        );
        return new Cat("Bars", 3, kids);
    }
}
