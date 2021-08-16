package com.epam.jwd.repository.comparator;

import com.epam.jwd.entity.CubeEntity;

import java.util.Comparator;

public class CubeFirstNodeXComparator implements Comparator<CubeEntity> {

    @Override
    public int compare(CubeEntity firstCube, CubeEntity secondCube) {
        return (int)(firstCube.getNodesOfLowerBase().get(0).getX() - secondCube.getNodesOfLowerBase().get(0).getX());
    }
}
