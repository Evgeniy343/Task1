package com.epam.jwd.repository.comparator;

import com.epam.jwd.entity.CubeEntity;

import java.util.Comparator;

public class CubeVolumeComparator implements Comparator<CubeEntity> {

    @Override
    public int compare(CubeEntity firstCube, CubeEntity secondCube) {
        return (int)(firstCube.getRegistrars().get(0).getContext().getVolume()
                - secondCube.getRegistrars().get(0).getContext().getVolume());
    }
}
