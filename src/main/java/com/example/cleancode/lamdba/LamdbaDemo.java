package com.example.cleancode.lamdba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author : wyn
 * @date : 2022-08-25 23:51
 **/
public class LamdbaDemo {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("111");
        strings.add("3");
        strings.add("21");
        strings.sort(Comparator.comparingInt(String::length));
        System.out.println(strings);
    }
}
