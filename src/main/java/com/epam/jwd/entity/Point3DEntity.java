package com.epam.jwd.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Point3DEntity {

    public static final String POINT_BEING_CREATED_MESSAGE = "The point is being created";
    public static final String POINT_CREATED_MESSAGE = "Point %s was created";
    private static final Logger LOG = LogManager.getLogger(Point3DEntity.class);
    private final double x;
    private final double y;
    private final double z;

    Point3DEntity(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Point3DEntity of(double x, double y, double z) {
        LOG.info(POINT_BEING_CREATED_MESSAGE);
        Point3DEntity point = new Point3DEntity(x, y, z);
        LOG.info(String.format(POINT_CREATED_MESSAGE, point.toString()));
        return point;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Point3DEntity{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3DEntity that = (Point3DEntity) o;
        return Double.compare(that.x, x) == 0 &&
                Double.compare(that.y, y) == 0 &&
                Double.compare(that.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
