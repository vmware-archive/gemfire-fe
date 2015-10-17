package io.pivotal.bds.gemfire.data.ecom;

public class Dimensions {

    private double x;
    private double y;
    private double z;
    private LengthUnit unit;

    public Dimensions() {
    }

    public Dimensions(double x, double y, double z, LengthUnit unit) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.unit = unit;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    public void setUnit(LengthUnit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Dimensions [x=" + x + ", y=" + y + ", z=" + z + ", unit=" + unit + "]";
    }

}
