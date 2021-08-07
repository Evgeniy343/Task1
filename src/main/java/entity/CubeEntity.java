package entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CubeEntity {
    private static final Logger LOG = LogManager.getLogger(CubeEntity.class);
    private static final int FOURTH_NODE_INDEX = 3;
    private static final int FIRST_NODE_INDEX = 0;
    private static final String CUBE_BEING_CREATED_MESSAGE = "The cube is being created";
    private static final String CUBE_CREATED_MESSAGE = "Cube %s was created";
    private final List<Point3DEntity> nodesOfUpperBase = new ArrayList<>();
    private final List<Point3DEntity> nodesOfLowerBase = new ArrayList<>();
    private final double edgeLength;

    CubeEntity(List<Point3DEntity> nodesOfUpperBase, List<Point3DEntity> nodesOfLowerBase) {
        this.nodesOfLowerBase.addAll(nodesOfLowerBase);
        this.nodesOfUpperBase.addAll(nodesOfUpperBase);
        this.edgeLength = nodesOfUpperBase.get(FOURTH_NODE_INDEX).getX()
                - nodesOfUpperBase.get(FIRST_NODE_INDEX).getX();
    }

    public static CubeEntity of(List<Point3DEntity> nodesOfUpperBase, List<Point3DEntity> nodesOfLowerBase){
        LOG.info(CUBE_BEING_CREATED_MESSAGE);
        CubeEntity cube = new CubeEntity(nodesOfUpperBase,nodesOfLowerBase);
        LOG.info(String.format(CUBE_CREATED_MESSAGE,cube.toString()));
        return cube;
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
        return "CubeEntity{" + "\n" +
                "nodesOfUpperBase=" + nodesOfUpperBase + "\n" +
                ",nodesOfLowerBase=" + nodesOfLowerBase + "\n" +
                ",edgeLength=" + edgeLength +
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
