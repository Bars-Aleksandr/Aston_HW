package org.example;

import org.example.calculateAreaTriangle.AreaTriangle;
import org.example.comparedTwoNumbers.ComparedTwoNumbers;
import org.example.factorial.Factorial;

public class Main {
    public static void main(String[] args) {
        System.out.println(Factorial.factorial(5));
        int a = 5, b = 5, c = 5;
        System.out.println(AreaTriangle.calculateAreaTriangle(a, b, c));
        ComparedTwoNumbers.comparedTwoNumbers(a, b);
    }
}
