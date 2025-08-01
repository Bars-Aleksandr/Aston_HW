package factorialTest;

import org.example.factorial.Factorial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class factorialTest {
    @ParameterizedTest(name = "№{index}: {0}! = {1}")
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120",
            "6, 720",
            "7, 5040",
            "8, 40320",
            "9, 362880",
            "10, 3628800",
            "11, 39916800",
            "12, 479001600"
    })
    void factorialForMAX_VALUEPositiveTest(int n, int expectedResult) {
        Assertions.assertEquals(expectedResult, Factorial.factorial(n));
    }

    @DisplayName("Вычисление факториала для нуля")
    @Test
    void factorialZero() {
        int actualResult = Factorial.factorial(0);
        Assertions.assertEquals(actualResult, 1);
    }

    @DisplayName("Вычисление факториала для единицы")
    @Test
    void factorialForOne() {
        int actualResult = Factorial.factorial(1);
        Assertions.assertEquals(actualResult, 1);
    }


    @Test
    void factorialForNegativeNumber() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                Factorial.factorial(-1), "Ожидаем IllegalArgumentException");
        Assertions.assertEquals("Для отрицательного числа факториал не определен.", exception.getMessage(), "Читай внимательно, есть опечатка");
    }

    @Test
    void checkExceptionForFactorialMoreMaxValueInt() {
        Exception exception = Assertions.assertThrows(ArithmeticException.class, () ->
                Factorial.factorial(13), "Ожидаем ArithmeticException");
        Assertions.assertEquals("Результат вышел за пределы диапазона integer.", exception.getMessage(), "Читай внимательно, есть опечатка");
    }

}
