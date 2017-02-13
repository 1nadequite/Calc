package calculator;

/**
 * Multiply operation implements multiply between two values;
 */
public class MultiplyOperation implements BinaryOperationIf {
    public double execute(double left, double right) {
        return left * right;
    }
}
