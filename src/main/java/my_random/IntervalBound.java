package my_random;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntervalBound<T extends Comparable<T>> {
    private T value;
    private boolean inclusive;

    public IntervalBound(@JsonProperty("inclusive") boolean inclusive, @JsonProperty("value") T value) {

        this.inclusive = inclusive;
        this.value = value;
    }

    public boolean isInclusive() {
        return inclusive;
    }

    public T getValue() {
        return value;
    }

}
