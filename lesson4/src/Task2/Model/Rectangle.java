package Task2.Model;

import Task2.Service.CalcArea;
import Task2.Service.CalcPerimeter;

public class Rectangle extends Share {
    private final int width;
    private final int height;
    private final int perimeter;
    private final int area;

    public Rectangle(int width, int height) {
        super( "blue", "yellow");
        this.height = height;
        this.width = width;
        this.perimeter = new CalcPerimeter().calculatePerimeterRectangle(this);
        this.area = new CalcArea().calculateAreaRectangle(this);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPerimeter() {
        return perimeter;
    }

    public int getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "[" + this.perimeter +
                ", " + this.area +
                ", " + super.getColorFill() +
                ", " + super.getColorBorder() +
                "]";
    }
}
