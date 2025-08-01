package factorialTest;

import org.example.factorial.Factorial;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialTest extends Assert {
    @DataProvider(name = "validDatesFactorial")
    public Object[][] validDatesFactorial(){
        return new Object[][]{
                {0, 1},
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120},
                {6, 720},
                {7, 5040},
                {8, 40320},
                {9, 362880},
                {10, 3628800},
                {11, 39916800},
                {12, 479001600}
        };
    }
    @Test(dataProvider = "validDatesFactorial")
    void positiveCalcFactorialTest(int n, int expectedResult){
        assertEquals(Factorial.factorial(n), expectedResult, "Факториал " + n + "! должен быть равен " + expectedResult);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testOverflow() {
        Factorial.factorial(13);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeNumberFactorial() {
        Factorial.factorial(-1);
    }
}
