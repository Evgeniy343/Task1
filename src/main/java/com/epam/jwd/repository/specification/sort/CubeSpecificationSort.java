package com.epam.jwd.repository.specification.sort;

import com.epam.jwd.entity.CubeEntity;

import java.util.List;

public interface CubeSpecificationSort {
    List<CubeEntity> specified(List<CubeEntity> cubes);
    static CubeSpecificationSort newInstance(SpecificationSort sort){
        switch (sort){
            case SPECIFICATION_VOLUME_SORT:
                return new CubeVolumeSpecificationSort();
            case SPECIFICATION_EDGE_LENGTH_SORT:
                return new CubeEdgeLengthSpecificationSort();
            case SPECIFICATION_FIRST_NODE_X_SORT:
                return new CubeFirstNodeXSpecificationSort();
        }
        return null;
    }
}
