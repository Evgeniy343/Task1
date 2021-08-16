package com.epam.jwd.repository.specification.sort;

import com.epam.jwd.entity.CubeEntity;
import com.epam.jwd.repository.comparator.CubeVolumeComparator;

import java.util.List;

public class CubeVolumeSpecificationSort implements CubeSpecificationSort {

    CubeVolumeSpecificationSort() {
    }

    @Override
    public List<CubeEntity> specified(List<CubeEntity> cubes) {
        cubes.sort(new CubeVolumeComparator());
        return cubes;
    }
}
