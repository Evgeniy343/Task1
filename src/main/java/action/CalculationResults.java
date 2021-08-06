package action;

public class CalculationResults {
    private final Double ratio;
    private final Double area;
    private final Double volume;
    private final Boolean isBaseOnPlane;
    private final Boolean isObject;

    public CalculationResults(Double ratio, Double area, Double volume, Boolean isBaseOnPlane, Boolean isObject) {
        this.ratio = ratio;
        this.area = area;
        this.volume = volume;
        this.isBaseOnPlane = isBaseOnPlane;
        this.isObject = isObject;
    }

    public Double getRatio() {
        return ratio;
    }

    public Double getArea() {
        return area;
    }

    public Double getVolume() {
        return volume;
    }

    public Boolean isBaseOnPlane() {
        return isBaseOnPlane;
    }

    public Boolean isObject() {
        return isObject;
    }
}
