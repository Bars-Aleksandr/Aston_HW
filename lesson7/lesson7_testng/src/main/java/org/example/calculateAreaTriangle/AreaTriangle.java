package org.example.calculateAreaTriangle;


public class AreaTriangle {
    public static double calculateAreaTriangle(double a, double b, double c) {
        if (!isTriangle(a, b, c)) {
            throw new IllegalArgumentException("Невозможно построить треугольник с такими сторонами.");
        }

        double p = semiPerimeterTriangle(a, b, c);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }


    private static double semiPerimeterTriangle(double a, double b, double c) {
        return (a + b + c) / 2.0;
    }
    private static boolean isTriangle(double a, double b, double c){
        return ((a + b) > c && (a + c) > b && (b + c) > a);
    }


}
