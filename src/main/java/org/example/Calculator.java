package org.example;

/**
 * @author Vladimir Bratchikov on 03.12.22
 */
public class Calculator<T extends Number> {

    private String name;

    public Calculator(String name, int i) {
        this.name = name + " (" + i + ")";
    }

    public String getName() {
        return name;
    }

    public Double calcSum(T p1, T p2) {
        return p1.doubleValue() + p2.doubleValue();
    }
}
