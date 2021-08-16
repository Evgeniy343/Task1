package com.epam.jwd.repository.specification.sort;

import com.epam.jwd.entity.CubeEntity;
import com.epam.jwd.repository.comparator.CubeEdgeLengthComparator;

import java.util.List;

public class CubeEdgeLengthSpecificationSort implements CubeSpecificationSort {

    CubeEdgeLengthSpecificationSort() {
    }

    @Override
    public List<CubeEntity> specified(List<CubeEntity> cubes) {
        cubes.sort(new CubeEdgeLengthComparator());
        return cubes;
    }
}
