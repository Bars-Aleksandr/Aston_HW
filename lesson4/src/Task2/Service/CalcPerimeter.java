package Task2.Service;

import Task2.Model.Circle;
import Task2.Model.Rectangle;
import Task2.Model.Triangle;

public class CalcPerimeter implements IPerimeter {

    @Override
    public int calculatePerimeterTriangle(Triangle triangle) {
        return triangle.getSideA() + triangle.getSideB() + triangle.getSideC();
    }

    @Override
    public double calculatePerimeterCircle(Circle circle) {
        return 2 * Math.PI * circle.getRadius();
    }

    @Override
    public int calculatePerimeterRectangle(Rectangle rectangle) {
        return  2 * (rectangle.getHeight() +  rectangle.getWidth());
    }
}
