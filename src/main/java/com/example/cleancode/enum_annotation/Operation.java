package com.example.cleancode.enum_annotation;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : wyn
 * @date : 2022-08-23 22:25
 **/
public enum Operation {
    PLUS("+") { public double apply(double x, double y) { return x + y; } },
    MINUS("-") { public double apply(double x, double y) { return x - y; } },
    TIMES("*") { public double apply(double x, double y) { return x * y; } },
    DIVIDE("/") { public double apply(double x, double y) { return x / y; } };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    private static final Map<String, Operation> stringToEnum = Stream.of(values())
            .collect(Collectors.toMap(Object::toString, e -> e));

    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public abstract double apply(double x, double y);

    public static void main(String[] args) {
        double x = 2;
        double y = 3;
        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
        Optional<Operation> operation = Operation.fromString("-");
        System.out.println(operation.get());
    }

}
