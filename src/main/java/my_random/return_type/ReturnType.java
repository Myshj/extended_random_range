package my_random.return_type;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReturnType<T> {
    private T value;

    public ReturnType(){}

    public ReturnType(@JsonProperty("value") T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ReturnType{" +
                "value=" + value +
                '}';
    }
}
