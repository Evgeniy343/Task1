package com.epam.jwd.repository.specification.find;

import com.epam.jwd.entity.CubeEntity;

public class CubeParamsSpecificationFind implements CubeSpecificationFind {

    private final Double volume;
    private final Double area;

    CubeParamsSpecificationFind(Double volume, Double area) {
        this.volume = volume;
        this.area = area;
    }

    @Override
    public boolean specified(CubeEntity cube) {
        return cube.getRegistrars().get(0).getContext().getVolume() == volume
                && cube.getRegistrars().get(0).getContext().getArea() == area;
    }
}
