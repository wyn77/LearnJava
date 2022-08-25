package com.example.cleancode.enum_annotation;

import com.example.cleancode.enum_annotation._interface.Operation;

import java.nio.file.LinkOption;

public enum ExtendedOperation implements Operation {
    EXP("^") {
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    PEMAINDER("%") {
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static void main(String[] args) {
        System.out.println(ExtendedOperation.EXP.apply(2 ,10));
        test(ExtendedOperation.class, 10, 2);
    }

    private static <T extends Enum<T> & com.example.cleancode.enum_annotation._interface.Operation> void test(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

}
