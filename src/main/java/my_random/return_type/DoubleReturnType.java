package my_random.return_type;

public class DoubleReturnType extends ReturnType<Double> {
    public DoubleReturnType() {
    }

    public DoubleReturnType(Double value) {
        super(value);
    }

    @Override
    public String toString() {
        return "DoubleReturnType{" +
                "value=" + getValue() +
                '}';
    }
}
