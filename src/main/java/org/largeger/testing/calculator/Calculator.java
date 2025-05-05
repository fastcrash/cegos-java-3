package org.largeger.testing.calculator;

public class Calculator {
    private int result;

    public Calculator() {
        this.result = 0;
    }

    public int getResult() {
        return result;
    }

    public void plus(int value) {
        result += value;
    }

    public void minus(int value) {
        result -= value;
    }

    public void times(int value)  {
        result *= value;
    }

    public void divided(int value)  {
        result /= value;
    }
}
