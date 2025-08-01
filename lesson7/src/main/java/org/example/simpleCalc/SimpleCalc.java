package org.example.simpleCalc;

public class SimpleCalc {

    public static int calc(int a, int b, char sign) {
        switch (sign) {
            case '+':
                return summa(a, b);
            case '-':
                return subtraction(a, b);
            case '*':
                return multiplication(a, b);
            case '/':
                return division(a, b);
            default:
                throw new IllegalArgumentException("Такого арифметического действия нет: '" + sign + "'");

        }
    }

    private static int division(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new IllegalArgumentException("Деление на ноль");
        }
    }

    private static int multiplication(int a, int b) {
        if (a != 0 && b != 0 &&
                ((a > 0 && b > 0 && a > Integer.MAX_VALUE / b) ||
                        (a < 0 && b < 0 && a < Integer.MAX_VALUE / b) ||
                        (a > 0 && b < 0 && a > Integer.MIN_VALUE / b) ||
                        (a < 0 && b > 0 && a < Integer.MIN_VALUE / b))) {
            throw new ArithmeticException("Переполнение при умножении!");
        }
        return a * b;
    }

    private static int subtraction(int a, int b) {
        if (((a >= 0 && b < 0 && a > Integer.MAX_VALUE + b) ||
                (a < 0 && b > 0 && a < Integer.MIN_VALUE + b))) {
            throw new ArithmeticException("Переполнение при вычитании!");
        }
        return a - b;
    }

    private static int summa(int a, int b) {
        if (a > 0 && b > 0 && a > Integer.MAX_VALUE - b ||
                a < 0 && b < 0 && a < Integer.MIN_VALUE - b) {
            throw new ArithmeticException("Переполнение при сложении!");
        }
        return a + b;
    }
}
