package com.epam.jwd.repository.specification.sort;

import com.epam.jwd.entity.CubeEntity;
import com.epam.jwd.repository.comparator.CubeFirstNodeXComparator;

import java.util.List;

public class CubeFirstNodeXSpecificationSort implements CubeSpecificationSort {

    CubeFirstNodeXSpecificationSort() {
    }

    @Override
    public List<CubeEntity> specified(List<CubeEntity> cubes) {
        cubes.sort(new CubeFirstNodeXComparator());
        return cubes;
    }
}
