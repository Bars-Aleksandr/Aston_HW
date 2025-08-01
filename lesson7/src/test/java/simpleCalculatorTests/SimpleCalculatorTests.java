package simpleCalculatorTests;

import org.example.simpleCalc.SimpleCalc;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class SimpleCalculatorTests {

    @Test
    @DisplayName("Сумма положительных чисел")
    void testSumma() {
        int actual = SimpleCalc.calc(3, 5, '+');
        assertEquals(8, actual);
    }

    @Test
    @DisplayName("Разность положительных чисел")
    void testSubtraction() {
        int actual = SimpleCalc.calc(10, 3, '-');
        assertEquals(7, actual);
    }

    @Test
    @DisplayName("Умножение положительных чисел")
    void testMultiplication() {
        int actual = SimpleCalc.calc(5, 3, '*');
        assertEquals(15, actual);
    }

    @ParameterizedTest(name = "{index}: Деление ({0})/{1}")
    @CsvSource({
            "10, 2",
            "9, 3",
            "15, 5"
    })
    @DisplayName("Корректное деление положительных чисел")
    void testDivision(int dividend, int divisor) {
        int actual = SimpleCalc.calc(dividend, divisor, '/');
        assertEquals(dividend / divisor, actual);
    }

    @Test
    @DisplayName("Деление на ноль")
    void testDivisionByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> SimpleCalc.calc(10, 0, '/'));
        assertTrue(exception.getMessage().contains("Деление на ноль"));
    }

    @ParameterizedTest(name = "{index}: Некорректный оператор '{0}'")
    @ValueSource(chars = {'%', '^', '#'})
    @DisplayName("Некорректные операторы")
    void testInvalidOperator(char invalidSign) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> SimpleCalc.calc(10, 5, invalidSign));
        assertTrue(exception.getMessage().contains("Такого арифметического действия нет"));
    }

    @Test
    @DisplayName("Сложение с отрицательным числом")
    void testSumWithNegative() {
        int actual = SimpleCalc.calc(10, -5, '+');
        assertEquals(5, actual);
    }


    @Test
    @DisplayName("Умножение отрицательных чисел")
    void testMultiplyNegatives() {
        int actual = SimpleCalc.calc(-5, -3, '*');
        assertEquals(15, actual);
    }


    @Test
    @DisplayName("Делимость нуля на ненулевое число")
    void testDivideZeroByNonZero() {
        int actual = SimpleCalc.calc(0, 5, '/');
        assertEquals(0, actual);
    }

    @Test
    @DisplayName("Умножение нуля на другое число")
    void testMultiplyZero() {
        int actual = SimpleCalc.calc(0, 10, '*');
        assertEquals(0, actual);
    }



    @Test
    @DisplayName("Число делится само на себя")
    void testDividingSelfBySelf() {
        int actual = SimpleCalc.calc(10, 10, '/');
        assertEquals(1, actual);
    }

    @Test
    @DisplayName("Вычитание большего числа из меньшего")
    void testSubtractLargerFromSmaller() {
        int actual = SimpleCalc.calc(3, 5, '-');
        assertEquals(-2, actual);
    }


    @Test
    @DisplayName("Переполнение при сложении")
    void testOverflowOnAddition() {
        Exception exception = assertThrows(ArithmeticException.class, () -> SimpleCalc.calc(Integer.MAX_VALUE, 1, '+')); // Суммируем самое большое число с 1
        assertTrue(exception.getMessage().contains("Переполнение при сложении"));
    }

    @Test
    @DisplayName("Переполнение при умножении")
    void testOverflowOnMultiplication() {
        Exception exception = assertThrows(ArithmeticException.class, () -> SimpleCalc.calc(Integer.MAX_VALUE, 2, '*')); // Умножаем наибольшее число на 2
        assertTrue(exception.getMessage().contains("Переполнение при умножении"));
    }
}