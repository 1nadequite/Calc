package calculator.BinaryOperations;

/**
 * Divide operation divides the left value by the right value.
 */
public class DivideOperation implements BinaryOperationIf {
    @Override
    public double execute(double left, double right) {
        if (right == 0) {
            throw new IllegalArgumentException("Division by zero.");
        }
        return left / right;
    }
}
