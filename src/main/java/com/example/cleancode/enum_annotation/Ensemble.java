package com.example.cleancode.enum_annotation;

public enum Ensemble {

    SOLO(1), DUET(2);

    private final int numberOfMusicians;

    Ensemble(int size) {
        this.numberOfMusicians = size;
    }

    public int numberOfMusicians() {
        return numberOfMusicians;
    }

    public static void main(String[] args) {
        System.out.println(Ensemble.DUET.numberOfMusicians());
    }
}
