package com.epam.jwd.entity;

import com.epam.jwd.entity.observable.CubeObservable;
import com.epam.jwd.registrar.CubeRegistrar;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CubeEntity implements CubeObservable {
    private static final int FOURTH_NODE_INDEX = 3;
    private static final int FIRST_NODE_INDEX = 0;
    private final List<Point3DEntity> nodesOfUpperBase = new ArrayList<>();
    private final List<Point3DEntity> nodesOfLowerBase = new ArrayList<>();
    private Double edgeLength;
    private final List<CubeRegistrar> registrars;

    CubeEntity(List<Point3DEntity> nodesOfUpperBase, List<Point3DEntity> nodesOfLowerBase) {
        registrars = null;
        setParams(nodesOfUpperBase,nodesOfLowerBase);
    }

    public static CubeEntity of(List<Point3DEntity> nodesOfUpperBase, List<Point3DEntity> nodesOfLowerBase) {
        return new CubeEntity(nodesOfUpperBase, nodesOfLowerBase);
    }

    @Override
    public CubeRegistrar addRegistrar(CubeRegistrar registrar) {
        registrars.add(registrar);
        return registrar;
    }

    @Override
    public CubeRegistrar removeRegistrar(CubeRegistrar registrar) {
        registrars.add(registrar);
        return registrar;
    }

    @Override
    public void notifyRegistrar() {
        registrars.get(0).update(this);
    }

    public Double getEdgeLength() {
        return edgeLength;
    }

    public List<Point3DEntity> getNodesOfUpperBase() {
        return nodesOfUpperBase;
    }

    public List<Point3DEntity> getNodesOfLowerBase() {
        return nodesOfLowerBase;
    }

    public List<CubeRegistrar> getRegistrars() {
        return registrars;
    }

    public void changeCubeParams(List<Point3DEntity> nodesOfUpperBase, List<Point3DEntity> nodesOfLowerBase){
        setParams(nodesOfUpperBase,nodesOfLowerBase);
        notifyRegistrar();
    }

    private void setParams(List<Point3DEntity> nodesOfUpperBase, List<Point3DEntity> nodesOfLowerBase){
        this.nodesOfLowerBase.addAll(nodesOfLowerBase);
        this.nodesOfUpperBase.addAll(nodesOfUpperBase);
        this.edgeLength = nodesOfUpperBase.get(FOURTH_NODE_INDEX).getX()
                - nodesOfUpperBase.get(FIRST_NODE_INDEX).getX();
    }

    @Override
    public String toString() {
        return "CubeEntity{" + "\n" +
                "nodesOfUpperBase=" + nodesOfUpperBase + "\n" +
                ",nodesOfLowerBase=" + nodesOfLowerBase + "\n" +
                ",edgeLength=" + edgeLength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeEntity that = (CubeEntity) o;
        return Double.compare(that.edgeLength, edgeLength) == 0 &&
                Objects.equals(nodesOfUpperBase, that.nodesOfUpperBase) &&
                Objects.equals(nodesOfLowerBase, that.nodesOfLowerBase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodesOfUpperBase, nodesOfLowerBase, edgeLength);
    }
}
