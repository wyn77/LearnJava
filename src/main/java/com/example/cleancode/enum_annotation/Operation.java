package com.example.cleancode.enum_annotation;

import java.util.Map;
import java.util.Optional;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : wyn
 * @date : 2022-08-23 22:25
 **/
public enum Operation {
    PLUS("+", (x,y) -> x + y),
    MINUS("-", (x,y) -> x - y),
    TIMES("*", (x,y) -> x * y) ,
    DIVIDE("/", (x,y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
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

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    };

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
