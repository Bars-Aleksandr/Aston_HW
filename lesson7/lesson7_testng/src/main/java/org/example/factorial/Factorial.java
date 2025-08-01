package org.example.factorial;

public class Factorial {
    public static int factorial(int n) throws ArithmeticException {
        if (n < 0) {
            throw new IllegalArgumentException("Для отрицательного числа факториал не определен.");
        }
        return recursiveWithCheckMaxValue(n, 1);
    }

    private static int recursiveWithCheckMaxValue(int n, int result) {
        if ((n == 0) || (n == 1)) {
            return result;
        }
        checkMaxValue(result, n);
        return recursiveWithCheckMaxValue(n - 1, result * n);

    }

    private static void checkMaxValue(int res, int n) {
        if ((res != 0 && Integer.MAX_VALUE / res < n) || (n != 0 && Integer.MAX_VALUE / n < res)) {
            throw new ArithmeticException("Результат вышел за пределы диапазона integer.");
        }
    }
}
