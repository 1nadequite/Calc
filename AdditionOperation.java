package calculator.BinaryOperations;

/**
 * Addition operation implements addition against two values.
 */
public class AdditionOperation implements BinaryOperationIf {
    public double execute(double left, double right) {
        return left + right;
    }
}
