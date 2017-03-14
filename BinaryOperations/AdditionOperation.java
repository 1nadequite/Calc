package calculator;

/**
 * Addition operation implements addition against two values.
 */
public class AdditionOperation implements BinaryOperationIf {
    @Override
    public double execute(double left, double right) {
        return left + right;
    }
}
