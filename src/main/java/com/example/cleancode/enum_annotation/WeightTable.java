package com.example.cleancode.enum_annotation;

import java.math.RoundingMode;

/**
 * @author : wyn
 * @date : 2022-08-23 22:10
 **/
public class WeightTable {

    public static void main(String[] args) {
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / Planet.MERCURY.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p, p.surfaceGravity(mass));
        }

    }
}
