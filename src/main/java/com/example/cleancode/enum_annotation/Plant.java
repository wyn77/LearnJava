package com.example.cleancode.enum_annotation;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : wyn
 * @date : 2022-08-25 21:20
 **/
public class Plant {
    enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {

        Plant[] garden = new Plant[]{
                new Plant("annual", LifeCycle.ANNUAL),
                new Plant("perennial", LifeCycle.PERENNIAL),
                new Plant("biennial", LifeCycle.BIENNIAL)
        };

        Map<LifeCycle, Set<Plant>> plantsByLifeCycle =
                new EnumMap<>(LifeCycle.class);

        for (LifeCycle lc : LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }

        for(Plant p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }
        System.out.println(plantsByLifeCycle);

        System.out.println(Arrays.stream(garden).collect(Collectors.groupingBy(e -> e.lifeCycle)));

        System.out.println(Arrays.stream(garden).collect(Collectors.groupingBy(e -> e.lifeCycle,
                () -> new EnumMap<>(LifeCycle.class), Collectors.toSet())));

    }

}
