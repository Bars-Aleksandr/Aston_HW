package comparedNumber;

import org.example.comparedTwoNumbers.ComparedTwoNumbers;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ComparedTwoNumbersTest extends Assert {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    @BeforeMethod
    private void setUpStream(){
        System.setOut(new PrintStream(outputStream));
    }

    @AfterMethod
    private void tearDown(){
        outputStream.reset();
        System.setOut(System.out);
    }

    @DataProvider(name = "comparedData")
    public Object[][] comparedData(){
        return new Object[][]{
                {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE + " > " + Integer.MIN_VALUE},
                {-1, 0, "-1 < 0"},
                {0, 1, "0 < 1"},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE + " = " + Integer.MAX_VALUE},
                {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE + " = " + Integer.MIN_VALUE},
                {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE + " < " + Integer.MAX_VALUE},
                {0, 0, "0 = 0"},
                {-1, -2, "-1 > -2"},
                {5, 3, "5 > 3"}
        };
    }
    @Test(dataProvider = "comparedData")
    void testComperedTwoNumbers(int num1, int num2, String expectedResult){
        ComparedTwoNumbers.comparedTwoNumbers(num1, num2);
        assertEquals(outputStream.toString().strip(), expectedResult);
    }
}
