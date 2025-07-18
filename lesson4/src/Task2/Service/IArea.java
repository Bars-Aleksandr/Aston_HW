package Task2.Service;

import Task2.Model.Circle;
import Task2.Model.Rectangle;
import Task2.Model.Triangle;

public interface IArea {
    double calculateAreaTriangle(Triangle triangle);
    double calculateAreaCircle(Circle circle);
    int calculateAreaRectangle(Rectangle rectangle);
}
