package server;

import my_random.Interval;
import my_random.IntervalBound;

public class IntervalForm {
    private Double min;
    private Double max;

    private Boolean minInclusive;
    private Boolean maxInclusive;

    private String type;

    public Interval<Double> toInterval() {
        return new Interval<>(
                getMin() == null ?
                        null :
                        new IntervalBound<>(
                                getMinInclusive(),
                                getMin()
                        ),
                getMax() == null ?
                        null :
                        new IntervalBound<>(
                                getMaxInclusive(),
                                getMax()
                        )
        );
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Boolean getMinInclusive() {
        return minInclusive;
    }

    public void setMinInclusive(Boolean minInclusive) {
        this.minInclusive = minInclusive;
    }

    public Boolean getMaxInclusive() {
        return maxInclusive;
    }

    public void setMaxInclusive(Boolean maxInclusive) {
        this.maxInclusive = maxInclusive;
    }

}
