package my_random;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Interval<T extends Comparable<T>> {
    private IntervalBound<T> min;
    private IntervalBound<T> max;
    private boolean valid;

    public Interval(@JsonProperty("min") IntervalBound<T> min, @JsonProperty("max") IntervalBound<T> max) {
        this.min = min;
        this.max = max;
        calculateValid();
    }

    public boolean isValid() {
        return valid;
    }

    public IntervalBound<T> getMin() {
        return min;
    }

    public IntervalBound<T> getMax() {
        return max;
    }

    private void calculateValid() {
        if (min == null || max == null) {
            valid = true;
            return;
        }
        if (min.isInclusive() && max.isInclusive()) {
            valid = min.getValue().compareTo(max.getValue()) <= 0;
            return;
        }
        valid = min.getValue().compareTo(max.getValue()) < 0;

    }

//    public boolean contains(int value) {
//        if (!valid) {
//            return false;
//        }
//        if (min == null) {
//            if (max == null) {
//                return true;
//            }
//            if (max.isInclusive()) {
//                return value <= max.getValue();
//            }
//            return value < max.getValue();
//        }
//        if (max == null) {
//            if (min.isInclusive()) {
//                return value >= min.getValue();
//            }
//            return value > min.getValue();
//        }
//        if (min.isInclusive()) {
//            if (max.isInclusive()) {
//                return min.getValue() <= value && value <= max.getValue();
//            }
//            return min.getValue() <= value && value < max.getValue();
//        }
//        if (max.isInclusive()) {
//            return min.getValue() < value && value <= max.getValue();
//        }
//        return min.getValue() < value && value < max.getValue();
//    }
}
