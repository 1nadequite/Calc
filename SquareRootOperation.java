package calculator;

/**
 * Square operation calculates the square of a value;
 */
public class SqrtOperation implements UnaryOperationIf {
    @Override
    public double execute(double value) {
        return value * value;
    }
}
