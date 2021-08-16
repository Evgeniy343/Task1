package com.epam.jwd.repository.specification.find;

import com.epam.jwd.entity.CubeEntity;
import com.epam.jwd.entity.Point3DEntity;

import java.util.List;

public class CubeBasesSpecificationFind implements CubeSpecificationFind {

    private final List<Point3DEntity> upperBase;
    private final List<Point3DEntity> lowerBase;

    CubeBasesSpecificationFind(List<Point3DEntity> upperBase, List<Point3DEntity> lowerBase) {
        this.upperBase = upperBase;
        this.lowerBase = lowerBase;
    }

    @Override
    public boolean specified(CubeEntity cube) {
        return cube.getNodesOfLowerBase().equals(lowerBase) || cube.getNodesOfUpperBase().equals(upperBase);
    }


}
