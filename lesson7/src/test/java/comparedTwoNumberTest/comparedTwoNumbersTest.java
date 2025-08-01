package comparedTwoNumberTest;

import org.example.comparedTwoNumbers.ComparedTwoNumbers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class comparedTwoNumbersTest {

    private final ByteArrayOutputStream outputDataStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputDataStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void checkCompareMaxValueInt() {
        ComparedTwoNumbers.comparedTwoNumbers(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Assertions.assertEquals(Integer.MAX_VALUE + " = " + Integer.MAX_VALUE + "\r\n",
                outputDataStream.toString());
    }
    @Test
    void checkCompareMinValueInt() {
        ComparedTwoNumbers.comparedTwoNumbers(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Assertions.assertEquals(Integer.MIN_VALUE + " = " + Integer.MIN_VALUE + System.lineSeparator(),
                outputDataStream.toString());
    }

    @Test
    void checkCompareMinWithMaxValueInt() {
        ComparedTwoNumbers.comparedTwoNumbers(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Assertions.assertEquals(Integer.MIN_VALUE + " < " + Integer.MAX_VALUE + System.lineSeparator(),
                outputDataStream.toString());
    }

    @Test
    void compareZeroWithZero(){
        ComparedTwoNumbers.comparedTwoNumbers(0, 0);
        Assertions.assertEquals(0 + " = " + 0 + System.lineSeparator(),
                outputDataStream.toString());
    }

    @Test
    void checkConditionGreaterThan(){
        ComparedTwoNumbers.comparedTwoNumbers(100, 0);
        Assertions.assertEquals(100 + " > " + 0 + System.lineSeparator(),
                outputDataStream.toString());
    }

}
