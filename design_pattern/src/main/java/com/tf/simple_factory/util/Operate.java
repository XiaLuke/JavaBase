package com.tf.simple_factory.util;

public abstract class Operate {
    private double numberA = 0;
    private double numberB = 0;

    public double getNumberA() {
        return numberA;
    }
    public Operate setNumbserA(double numberA) {
        this.numberA = numberA;
        return this;
    }

    public double getNumberB() {
        return numberB;
    }

    public Operate setNumberB(double numberB) {
        this.numberB = numberB;
        return this;
    }

    public double getResult() {
        double result = 0;
        return result;
    }
}
