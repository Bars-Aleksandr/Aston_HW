package Task2;

import Task2.Model.Circle;
import Task2.Model.Rectangle;
import Task2.Model.Triangle;

public class Main {
    public static void main(String[] args){
        System.out.println("Прямоугольник");
        System.out.println(new Rectangle(4, 5));
        System.out.println("Круг");
        System.out.println(new Circle(10));
        System.out.println("Треугольник");
        System.out.println(new Triangle(3, 5,7));

    }
}
