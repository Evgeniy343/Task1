package com.epam.jwd.repository.comparator;

import com.epam.jwd.entity.CubeEntity;

import java.util.Comparator;

public class CubeEdgeLengthComparator implements Comparator<CubeEntity> {

    @Override
    public int compare(CubeEntity firstCube, CubeEntity secondCube) {
        return (int)(firstCube.getEdgeLength() - secondCube.getEdgeLength());
    }
}
