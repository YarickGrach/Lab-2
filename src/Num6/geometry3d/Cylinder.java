package Num6.geometry3d;

import Num6.geometry2d.Figure;
import Num6.exceptions.*;

public class Cylinder {
    private Figure base;
    private double height;

    public Cylinder(Figure base, double height) {
        if (base == null) {
            throw new InvalidGeometryException("Base figure cannot be null");
        }
        if (height <= 0) {
            throw new InvalidGeometryException("Height must be positive: " + height);
        }
        this.base = base;
        this.height = height;
    }

    public double volume() {
        try {
            return base.area() * height;
        } catch (Exception e) {
            throw new CalculationException("Error calculating cylinder volume", e);
        }
    }

    public Figure getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return String.format("Cylinder(base=%s, height=%.2f, volume=%.2f)",
                base.toString(), height, volume());
    }
}