package Num6.geometry2d;

import Num6.exceptions.InvalidGeometryException;

public class Circle implements Figure {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new InvalidGeometryException("Radius must be positive: " + radius);
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return String.format("Circle(radius=%.2f, area=%.2f, perimeter=%.2f)",
                radius, area(), perimeter());
    }
}

