package com.epam.jwd.repository.specification.find;

import com.epam.jwd.entity.CubeEntity;
import com.epam.jwd.repository.specification.find.context.CubeSpecificationContext;

public interface CubeSpecificationFind {
    boolean specified(CubeEntity cube);
    static CubeSpecificationFind newInstance(SpecificationFind find, CubeSpecificationContext context){
        switch (find) {
            case SPECIFICATION_BASES_FIND:
                return new CubeBasesSpecificationFind(context.getUpperBase(),context.getLowerBase());
            case SPECIFICATION_PARAMS_FIND:
                return new CubeParamsSpecificationFind(context.getVolume(),context.getArea());
            case SPECIFICATION_EDGE_LENGTH_FIND:
                return new CubeEdgeLengthSpecificationFind(context.getLeftEdgeLength(),context.getRightEdgeLength());
        }
        return null;
    }
}
