package Task2.Service;

import Task2.Model.Circle;
import Task2.Model.Rectangle;
import Task2.Model.Triangle;

public class CalcArea implements IArea {
    @Override
    public double calculateAreaTriangle(Triangle triangle) {
        double p = triangle.getPerimeter() / 2d;
        return  Math.sqrt(p * (p - triangle.getSideA()) * (p - triangle.getSideB()) * (p - triangle.getSideC()));
    }

    @Override
    public double calculateAreaCircle(Circle circle) {
        return Math.PI * circle.getRadius() * circle.getRadius();
    }

    @Override
    public int calculateAreaRectangle(Rectangle rectangle) {
        return rectangle.getWidth() * rectangle.getHeight();
    }
}
