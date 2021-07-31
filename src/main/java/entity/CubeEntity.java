package entity;

public class CubeEntity {
    private final Point3DEntity node;
    private final double edgeLength;

    public CubeEntity(int edgeLength, Point3DEntity node) {
        this.edgeLength = edgeLength;
        this.node = node;
    }

    public Point3DEntity getNode() {
        return node;
    }

    public double getEdgeLength() {
        return edgeLength;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "node=" + node +
                ", edgeLength=" + edgeLength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeEntity cube = (CubeEntity) o;
        return edgeLength == cube.edgeLength &&
                node.equals(cube.node);
    }


}
