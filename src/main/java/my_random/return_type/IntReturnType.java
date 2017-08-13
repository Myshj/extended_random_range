package my_random.return_type;

public class IntReturnType extends ReturnType<Integer> {
    public IntReturnType() {
    }

    public IntReturnType(Integer value) {
        super(value);
    }

    @Override
    public String toString() {
        return "IntReturnType{" +
                "value=" + getValue() +
                '}';
    }
}
