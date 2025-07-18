package Task2.Service;

import Task2.Model.Circle;
import Task2.Model.Rectangle;
import Task2.Model.Triangle;

public interface IPerimeter {
    int calculatePerimeterTriangle(Triangle triangle);
    double calculatePerimeterCircle(Circle circle);
    int calculatePerimeterRectangle(Rectangle rectangle);
}
