package entity;
import java.util.List;

public class CubeEntity {
    public static final int FOURTH_NODE_INDEX = 3;
    public static final int FIRST_NODE_INDEX = 0;
    private final List<Point3DEntity> nodesOfUpperBase;
    private final List<Point3DEntity> nodesOfLowerBase;
    private final double edgeLength;

    private CubeEntity(List<Point3DEntity> nodesOfUpperBase, List<Point3DEntity> nodesOfLowerBase) {
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

        if (Double.compare(that.edgeLength, edgeLength) != 0) return false;
        if (nodesOfUpperBase != null ? !nodesOfUpperBase.equals(that.nodesOfUpperBase) : that.nodesOfUpperBase != null)
            return false;
        return nodesOfLowerBase != null ? nodesOfLowerBase.equals(that.nodesOfLowerBase) : that.nodesOfLowerBase == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = nodesOfUpperBase != null ? nodesOfUpperBase.hashCode() : 0;
        result = 31 * result + (nodesOfLowerBase != null ? nodesOfLowerBase.hashCode() : 0);
        temp = Double.doubleToLongBits(edgeLength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
