package com.example.cleancode.enum_annotation;

/**
 * @author : wyn
 * @date : 2022-08-25 22:27
 **/
public class Sample {
    @MyTest
    public static void m1() {
        System.out.println("m1");
    }

    @MyTest
    public static void m2() {
        throw new RuntimeException("Crash");
    }

    @MyTest
    public static void m3() {

    }

    public void m4() {

    }
}
