package com.example.cleancode.enum_annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wyn
 * @date : 2022-08-25 22:43
 **/
public class Sample2 {

    @ExceptionTest(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArrayIndexOutOfBoundsException.class)
    public static void m2() {
       int[] a = new int[0];
       int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() {

    }

    @ExceptionTest(IndexOutOfBoundsException.class)
    @ExceptionTest(NullPointerException.class)
    public static void m4() {
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }
}
