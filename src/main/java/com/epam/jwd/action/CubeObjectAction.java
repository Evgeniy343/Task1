package com.epam.jwd.action;

import com.epam.jwd.action.context.GeometryContext;
import com.epam.jwd.entity.CubeEntity;
import com.epam.jwd.entity.Point3DEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CubeObjectAction implements CubeGeometryAction {

    private static final Logger LOG = LogManager.getLogger(CubeObjectAction.class);
    private static final int NUMBER_OF_CUBE_EDGES = 12;
    private static final int NUMBER_OF_CUBE_BASE_EDGES = 4;
    private static final int NUMBER_OF_CUBE_BASES_EDGES = 8;
    private static final int FIRST_NODE_INDEX = 0;
    private static final int FORTH_NODE_INDEX = 3;
    private static final String CHECKING_CUBE_OBJECT_MESSAGE
            = "The object is being checked for compliance with the cube";
    private static final String FINISH_CHECKING_CUBE_OBJECT_MESSAGE
            = "The operation to check the object is the cube is completed";
    private static final String RESULT_MESSAGE = "Object is a cube - ";


    @Override
    public Object execute(GeometryContext context) {
        boolean isCube = prove(context.getCube());
        LOG.info(RESULT_MESSAGE + isCube);
        LOG.info(FINISH_CHECKING_CUBE_OBJECT_MESSAGE);
        return isCube;
    }

    private boolean prove(CubeEntity cube) {
        LOG.info(CHECKING_CUBE_OBJECT_MESSAGE);
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
        for (int i = 0; i < base.size() - 1; i++) {
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
        if (Math.abs(base.get(FIRST_NODE_INDEX).getX()
                - base.get(FORTH_NODE_INDEX).getX()) == edgeLength) {
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
