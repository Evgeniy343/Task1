package com.epam.jwd.repository.specification.find.context;

import com.epam.jwd.entity.Point3DEntity;

import java.util.List;

public class CubeSpecificationContext {

    private final List<Point3DEntity> upperBase;
    private final List<Point3DEntity> lowerBase;
    private final Double leftEdgeLength;
    private final Double rightEdgeLength;
    private final Double volume;
    private final Double area;

    public CubeSpecificationContext(List<Point3DEntity> upperBase, List<Point3DEntity> lowerBase
            , Double leftEdgeLength, Double rightEdgeLength, Double volume, Double area) {
        this.upperBase = upperBase;
        this.lowerBase = lowerBase;
        this.leftEdgeLength = leftEdgeLength;
        this.rightEdgeLength = rightEdgeLength;
        this.volume = volume;
        this.area = area;
    }

    public List<Point3DEntity> getUpperBase() {
        return upperBase;
    }

    public List<Point3DEntity> getLowerBase() {
        return lowerBase;
    }

    public Double getLeftEdgeLength() {
        return leftEdgeLength;
    }

    public Double getRightEdgeLength() {
        return rightEdgeLength;
    }

    public Double getVolume() {
        return volume;
    }

    public Double getArea() {
        return area;
    }
}
