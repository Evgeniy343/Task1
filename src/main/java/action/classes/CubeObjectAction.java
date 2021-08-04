package action.classes;

import action.interfaces.CubePoofAction;
import entity.CubeEntity;
import entity.Point3DEntity;

import java.util.List;

public class CubeObjectAction implements CubePoofAction {

    public static final int NUMBER_OF_CUBE_EDGES = 12;
    public static final int NUMBER_OF_CUBE_BASE_EDGES = 4;
    public static final int NUMBER_OF_CUBE_BASES_EDGES = 8;

    @Override
    public boolean check(CubeEntity cube) {
        int countEdges = 0;
        countEdges = countingEqualEdgesOfBase(cube.getNodesOfUpperBase(), countEdges, cube.getEdgeLength());
        if (countEdges == NUMBER_OF_CUBE_BASE_EDGES) {
            countEdges = countingEqualEdgesOfBase(cube.getNodesOfLowerBase(), countEdges, cube.getEdgeLength());
            if (countEdges == NUMBER_OF_CUBE_BASES_EDGES) {
                countEdges = countingEqualSideEdges(cube, countEdges);
            }
        }
        return countEdges == NUMBER_OF_CUBE_EDGES;
    }

    private int countingEqualEdgesOfBase(List<Point3DEntity> base, int countEdges, double edgeLength) {
        for (int i = 0; i < base.size(); i++) {
            if ((i + 1) % 2 == 0) {
                if (Math.abs(base.get(i + 1).getX() - base.get(i).getX()) == edgeLength) {
                    countEdges++;
                } else {
                    break;
                }
            } else {
                if (Math.abs(base.get(i + 1).getY()
                        - base.get(i).getY()) == edgeLength) {
                    countEdges++;
                } else {
                    break;
                }
            }
        }
        if (Math.abs(base.get(0).getX()
                - base.get(3).getX()) == edgeLength) {
            countEdges++;
        }
        return countEdges;
    }

    private int countingEqualSideEdges(CubeEntity cube, int countEdges) {
        for (int i = 0; i < cube.getNodesOfUpperBase().size(); i++) {
            if (cube.getNodesOfUpperBase().get(i).getZ()
                    - cube.getNodesOfLowerBase().get(i).getZ() == cube.getEdgeLength()) {
                countEdges++;
            } else {
                break;
            }
        }
        return countEdges;
    }
}
