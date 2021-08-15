package com.epam.jwd.registrar.context;

public class CubeContext {
    private double volume;
    private double area;

    CubeContext(int volume, Integer volumeRatio, int area) {
        this.volume = volume;
        this.area = area;
    }

    public static CubeContext of(int volume, Integer volumeRatio, int area){
        return new CubeContext(volume,volumeRatio,area);
    }

    public double getVolume() {
        return volume;
    }

    public double getArea() {
        return area;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
