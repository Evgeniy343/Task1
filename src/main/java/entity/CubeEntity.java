package entity;
import java.util.List;
import java.util.Objects;

public class CubeEntity {
    public static final int FOURTH_NODE_INDEX = 3;
    public static final int FIRST_NODE_INDEX = 0;
    private final List<Point3DEntity> nodesOfUpperBase;
    private final List<Point3DEntity> nodesOfLowerBase;
    private final double edgeLength;

    CubeEntity(List<Point3DEntity> nodesOfUpperBase, List<Point3DEntity> nodesOfLowerBase) {
        this.nodesOfLowerBase = nodesOfLowerBase;
        this.nodesOfUpperBase = nodesOfUpperBase;
        this.edgeLength = nodesOfUpperBase.get(FOURTH_NODE_INDEX).getX()
                - nodesOfUpperBase.get(FIRST_NODE_INDEX).getX();
    }

    public static CubeEntity of(List<Point3DEntity> nodesOfUpperBase, List<Point3DEntity> nodesOfLowerBase){
        return new CubeEntity(nodesOfUpperBase,nodesOfLowerBase);
    }

    public double getEdgeLength() {
        return edgeLength;
    }

    public List<Point3DEntity> getNodesOfUpperBase() {
        return nodesOfUpperBase;
    }

    public List<Point3DEntity> getNodesOfLowerBase() {
        return nodesOfLowerBase;
    }

    @Override
    public String toString() {
        return "CubeEntity{" +
                "nodesOfUpperBase=" + nodesOfUpperBase +
                ", nodesOfLowerBase=" + nodesOfLowerBase +
                ", edgeLength=" + edgeLength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeEntity that = (CubeEntity) o;
        return Double.compare(that.edgeLength, edgeLength) == 0 &&
                Objects.equals(nodesOfUpperBase, that.nodesOfUpperBase) &&
                Objects.equals(nodesOfLowerBase, that.nodesOfLowerBase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodesOfUpperBase, nodesOfLowerBase, edgeLength);
    }
}
