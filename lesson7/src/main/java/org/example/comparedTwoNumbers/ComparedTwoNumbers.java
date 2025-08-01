package org.example.comparedTwoNumbers;

public class ComparedTwoNumbers {
    public static void comparedTwoNumbers(int num1, int num2) {
        if (num1 > num2) {
            System.out.println(num1 + " > " + num2);
        } else if (num1 < num2) {
            System.out.println(num1 + " < " + num2);
        } else {
            System.out.println(num1 + " = " + num2);
        }
    }
}
