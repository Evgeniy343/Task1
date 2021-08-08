package com.epam.jwd.results;

public class TestResults {
    private final Double[] calculations;
    private final boolean isBaseOnPlane;
    private final boolean isCube;

    TestResults(Double[] calculations, boolean isBaseOnPlane, boolean isCube) {
        this.calculations = calculations;
        this.isBaseOnPlane = isBaseOnPlane;
        this.isCube = isCube;
    }

    public static TestResults of(Double[] calculations, boolean isBaseOnPlane, boolean isCube){
        return new TestResults(calculations,isBaseOnPlane,isCube);
    }

    public Double[] getCalculations() {
        return calculations;
    }

    public boolean isBaseOnPlane() {
        return isBaseOnPlane;
    }

    public boolean isCube() {
        return isCube;
    }
}
