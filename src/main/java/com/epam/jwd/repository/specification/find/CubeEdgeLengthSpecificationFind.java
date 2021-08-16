package com.epam.jwd.repository.specification.find;

import com.epam.jwd.entity.CubeEntity;

public class CubeEdgeLengthSpecificationFind implements CubeSpecificationFind {

    private final Double leftEdgeLength;
    private final Double rightEdgeLength;

    CubeEdgeLengthSpecificationFind(Double leftEdgeLength, Double rightEdgeLength) {
        this.leftEdgeLength = leftEdgeLength;
        this.rightEdgeLength = rightEdgeLength;
    }

    @Override
    public boolean specified(CubeEntity cube) {
        return cube.getEdgeLength() > leftEdgeLength && cube.getEdgeLength() < rightEdgeLength;
    }
}
