package Task2.Model;

import Task2.Service.CalcArea;
import Task2.Service.CalcPerimeter;

public class Triangle extends Share {
    private final int sideA;
    private final int sideB;
    private final int sideC;
    private final int perimeter;
    private final double area;

    public int getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    public Triangle(int sideA, int sideB, int sideC) {
        super("black", "white");
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.perimeter = new CalcPerimeter().calculatePerimeterTriangle(this);
        this.area = new CalcArea().calculateAreaTriangle(this);
    }



    public int getSideA() {
        return sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public int getSideC() {
        return sideC;
    }
    @Override
    public String toString() {
        return "[" +
                + this.perimeter  +
                ", " + Math.round(this.area * 100d) / 100d +
                ", " + super.getColorFill() +
                ", " + super.getColorBorder() +
                "]";
    }

}
