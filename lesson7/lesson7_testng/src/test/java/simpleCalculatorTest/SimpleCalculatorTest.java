package simpleCalculatorTest;

import org.example.simpleCalc.SimpleCalc;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleCalculatorTest extends Assert {
    @DataProvider(name = "arithmeticOperations")
    public Object[][] arithmeticOperations() {
        return new Object[][]{
                {10, 5, '+', 15},
                {10, 5, '-', 5},
                {10, 5, '*', 50},
                {10, 5, '/', 2},
                {0, 0, '+', 0},
                {0, 0, '-', 0},
                {0, 0, '*', 0},
                {10, 1, '/', 10},
                {10, 10, '+', 20}
        };
    }

    @Test(dataProvider = "arithmeticOperations")
    public void testArithmetics(int a, int b, char operation, int expectedResult) {
        int result = SimpleCalc.calc(a, b, operation);
        Assert.assertEquals(result, expectedResult, "Результат операции '" + operation + "' должен быть равен " + expectedResult);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivisionByZero() {
        SimpleCalc.calc(10, 0, '/');
    }
    @Test(expectedExceptions = ArithmeticException.class)
    public void testMultiplicationOverflow() {
        SimpleCalc.calc(Integer.MAX_VALUE, 2, '*');
    }
    @Test(expectedExceptions = ArithmeticException.class)
    public void testSumOverflow() {
        SimpleCalc.calc(Integer.MAX_VALUE, 1, '+');
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testSubtractionOverflow() {
        SimpleCalc.calc(Integer.MIN_VALUE, 1, '-');
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testUnknownOperation() {
        SimpleCalc.calc(10, 5, '%');
    }
    @Test(expectedExceptions = ArithmeticException.class)
    public void testNegativeOverflow() {
        SimpleCalc.calc(Integer.MIN_VALUE, -1, '*');
    }

}
