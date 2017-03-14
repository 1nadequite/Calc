package calculator.BinaryOperations;

/**
 * Subtract operation implements subtract the right value from the left value;
 */
public class SubtractOperation implements BinaryOperationIf {
    @Override
    public double execute(double left, double right) {
        return left - right;
    }
}
