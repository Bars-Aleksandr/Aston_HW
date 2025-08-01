package calculateAreaTriagleTests;

import org.junit.jupiter.api.*;
import org.example.calculateAreaTriangle.AreaTriangle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateAreaTriangleTest {


    @ParameterizedTest(name = "№{index}: Площадь треугольника при сторонах a=3, b=4, c={0}")
    @ValueSource(ints = {3, 4, 5})
    void calculateAreaTrianglePositiveTestFixedSide(double c) {
        double p = (7d + c) / 2d;
        double expectedResult = Math.sqrt(p * (p - 3d) * (p - 4d) * (p - c));
        double actualResult = AreaTriangle.calculateAreaTriangle(3, 4, c);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "Тест №{index}: Площадь треугольника ({0},{1},{2}) = {3}")
    @CsvSource({
            "3, 4, 5, 6",
            "5, 5, 5, 11",
            "6, 8, 10, 24"
    })
    void calculateAreaTriangleExpectedResultTest(double a, double b, double c, double expectedResult) {
        double actualResult = Math.round(AreaTriangle.calculateAreaTriangle(a, b, c));
        assertEquals(expectedResult, actualResult, "Неправильная площадь");
    }

    @Test
    void calculateAreaTriangleWithZeroTest() {
        String message = "Невозможно построить треугольник с такими сторонами.";
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
            AreaTriangle.calculateAreaTriangle(3, 4, 0), "Исключение не возникло"
        );
        Assertions.assertEquals(message, exception.getMessage());
    }
    @Test
    void calculateAreaNegativeSidesTest() {
        String message = "Невозможно построить треугольник с такими сторонами.";
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                AreaTriangle.calculateAreaTriangle(3, 4, -3), "Исключение не возникло"
        );
        Assertions.assertEquals(message, exception.getMessage());
    }
}
