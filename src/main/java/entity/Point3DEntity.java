package entity;

public class Point3DEntity {
    private final double x;
    private final double y;
    private final double z;

    public Point3DEntity(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3DEntity point3D = (Point3DEntity) o;
        return x == point3D.x &&
                y == point3D.y;
    }

}
