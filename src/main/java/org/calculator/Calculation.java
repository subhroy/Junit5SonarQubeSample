package org.calculator;

public class Calculation {
    public Calculation()
    {

    }

    public double divide(int a, int b)
    {
        if(b==0)
        {
            throw new ArithmeticException();
        }
        else
        {
            return a/b;
        }
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int add(int a, int b) {
        return a + b;
    }

}
