package calculator;

/**
 * Subtract operation implements subtract the right value from the left value;
 */
public class SubtractOperation implements BinaryOperationIf {
    public double execute(double left, double right) {
        return left - right;
    }
}
