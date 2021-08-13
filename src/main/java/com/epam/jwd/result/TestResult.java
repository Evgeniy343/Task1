package com.epam.jwd.result;

public class TestResult {
    private final Double[] calculations;
    private final boolean isBaseOnPlane;
    private final boolean isCube;

    TestResult(Double[] calculations, boolean isBaseOnPlane, boolean isCube) {
        this.calculations = calculations;
        this.isBaseOnPlane = isBaseOnPlane;
        this.isCube = isCube;
    }

    public static TestResult of(Double[] calculations, boolean isBaseOnPlane, boolean isCube){
        return new TestResult(calculations,isBaseOnPlane,isCube);
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
