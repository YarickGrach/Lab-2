package Num6.geometry2d;

import Num6.exceptions.InvalidGeometryException;

public class Rectangle implements Figure {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new InvalidGeometryException(
                    "Width and height must be positive: " + width + "x" + height
            );
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return String.format("Rectangle(width=%.2f, height=%.2f, area=%.2f, perimeter=%.2f)",
                width, height, area(), perimeter());
    }
}