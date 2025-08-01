package calculateAreaTriangleTest;

import org.example.calculateAreaTriangle.AreaTriangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class areaTriangleTest extends Assert {
    @Test(description = "Тест вычисления площади треугольника с известными размерами")
    public void testCalculateAreaTriangle() {
        double area = AreaTriangle.calculateAreaTriangle(3, 4, 5);
        assertEquals(area, 6.0);
    }

    @DataProvider(name = "triangleDatePositive")
    public Object[][] triangleDatePositive() {
        return new Object[][]{
                {3, 4, 5, 6.0},
                {5, 12, 13, 30.0},
                {8, 15, 17, 60.0},
                {0.03, 0.04, 0.05, 0.0006}
        };
    }
    @Test(dataProvider = "triangleDatePositive", description = "parametrize positive test")
    void calculateAreaTrianglePositiveTest(double a, double b, double c, double expectedArea){
        double actualArea = AreaTriangle.calculateAreaTriangle(a, b, c);
        assertEquals(expectedArea, actualArea, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, description = "Тест на невозможность создание треугольника")
    public void testInvalidTriangle() {
        AreaTriangle.calculateAreaTriangle(1, 2, 3);
    }

    @DataProvider(name = "triangleDateNegative")
    public Object[][] triangleDateNegative() {
        return new Object[][]{
                {3, 4, 7},
                {5, 12, 25},
                {8, 15, 70},
                {3, 4, 0},
                {3, 4, -5},
                {0, 0, 0},

        };
    }
    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "triangleDateNegative", description = "parametrize negative test")
    void checkExceptionImpossibilityCreateTriangle(double a, double b, double c){
        AreaTriangle.calculateAreaTriangle(a, b, c);
    }

}
