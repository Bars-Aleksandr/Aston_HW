package Task2.Model;

import Task2.Service.CalcArea;
import Task2.Service.CalcPerimeter;

public class Circle extends Share {
    private final int radius;
    private final double perimeter;
    private final double area;

    public Circle(int radius) {
        super("red", "green");
        this.radius = radius;
        this.perimeter = new CalcPerimeter().calculatePerimeterCircle(this);
        this.area = new CalcArea().calculateAreaCircle(this);
    }

    public int getRadius() {
        return radius;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "[" +
                 + Math.round(this.perimeter * 100d) / 100d +
                ", " + Math.round(this.area * 100d) / 100d +
                ", " + super.getColorFill() +
                ", " + super.getColorBorder() +
                "]";
    }
}
