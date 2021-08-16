package com.epam.jwd.repository;

import com.epam.jwd.entity.CubeEntity;
import com.epam.jwd.entity.Point3DEntity;
import com.epam.jwd.repository.specification.find.CubeSpecificationFind;

import java.util.List;

public interface Repository {

    int add(CubeEntity cube);
    int delete(CubeEntity cube);
    CubeEntity update(CubeEntity changeCube, List<Point3DEntity> newUpperBase, List<Point3DEntity> newLowerBase);
    List<CubeEntity> query(CubeSpecificationFind specification);
    List<CubeEntity> getCubes();
    static Repository newInstance(List<CubeEntity> cubes){
        return new ArrayCubeRepository(cubes);
    }
}
